package org.overtime.common.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

/**
 * 针对于 服务({@code Service}) 的抽象父类，提供部分常规方法。
 *
 * @param <ID>  持久层实体主键类型
 * @param <T>   持久层实体类型
 * @param <REP> 持久层repository实现接口类型
 * @author ForteScarlet
 */
@SuppressWarnings("unused")
public abstract class BaseR2dbcService<T, ID extends Serializable, REP extends R2dbcRepository<T, ID>> {

    /**
     * 得到一个 {@link ReactiveCrudRepository} 实例。
     */
    protected abstract REP getRepository();

    /**
     * 得到一个 {@link OvertimeR2dbcEntityTemplate} 实例。
     */
    protected abstract OvertimeR2dbcEntityTemplate getOvertimeR2dbcEntityTemplate();

    protected R2dbcEntityTemplate getR2dbcEntityTemplate() {
        return getOvertimeR2dbcEntityTemplate().getR2dbcEntityTemplate();
    }


    /**
     * Returns the number of entities available.
     *
     * @return {@link Mono} emitting the number of entities.
     */
    public Mono<Long> count() {
        return getRepository().count();
    }

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} emitting the entity with the given id or {@link Mono#empty()} if none found.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    public Mono<T> findById(ID id) {
        return getRepository().findById(id);
    }

    /**
     * Returns whether an entity with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} emitting {@literal true} if an entity with the given id exists, {@literal false} otherwise.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    public Mono<Boolean> existsById(ID id) {
        return getRepository().existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return {@link Flux} emitting all entities.
     */
    public Flux<T> findAll() {
        return getRepository().findAll();
    }


    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity must not be {@literal null}.
     * @return {@link Mono} emitting the saved entity.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     */
    public <S extends T> Mono<S> save(S entity) {
        return getRepository().save(entity);
    }


    /**
     * 根据分页信息查询分页后的数据。
     *
     * @param entity   entity
     * @param pageable pageable
     * @param <S>      type
     * @return paged list.
     */
    public <S extends T> Flux<S> pagedList(@Nullable S entity, Class<S> entityClasses, Pageable pageable) {
        if (entity == null) {
            return getR2dbcEntityTemplate().select(Query.empty().with(pageable), entityClasses);
        }

        final Query query = toQuery(toExample(entity)).with(pageable);
        return getR2dbcEntityTemplate().select(query, entityClasses);
    }


    /**
     * 根据 Example 查询计数。
     *
     * @param entity entity.
     * @return count
     */
    public Mono<Long> count(@Nullable T entity) {
        if (entity == null) {
            return count();
        }
        final Example<T> example = toExample(entity);
        return getR2dbcEntityTemplate().count(toQuery(example), example.getProbeType());
    }


    /**
     * 将 entity 转化为 Example.
     *
     * @param entity entity
     * @return example.
     * @see #basicMatcher(ExampleMatcher)
     */
    protected Example<T> toExample(@NotNull T entity) {
        return Example.of(entity, basicMatcher(ExampleMatcher.matching()));
    }

    /**
     * 将 example 转化为 query。
     *
     * @param example example to query.
     * @return query
     */
    protected Query toQuery(Example<T> example) {
        final Class<T> type = example.getProbeType();
        final Query query = getOvertimeR2dbcEntityTemplate().getMappedExample(example);
        return basicQuery(query);
    }

    protected Query basicQuery(Query query) {
        return query;
    }

    /**
     * 基础查询matcher后置处理器。
     * 可以重写并定义基本的查询条件处理器。
     *
     * @param matcher matcher
     * @return matcher
     */
    protected ExampleMatcher basicMatcher(ExampleMatcher matcher) {
        return matcher;
    }

}
