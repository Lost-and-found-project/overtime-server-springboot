package org.overtime.service;

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
public abstract class BaseReactiveCrudService<T, ID extends Serializable, REP extends ReactiveCrudRepository<T, ID>> {

    /**
     * 得到一个 {@link ReactiveCrudRepository} 实例。
     */
    protected abstract REP getRepository();

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

}
