package org.overtime.admin.service;

import org.overtime.common.domain.PageableParameter;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
public interface BaseService<T> {

    /**
     * 根据ID查询结果
     *
     * @param id id
     * @return id
     */
    Mono<T> findById(Integer id);


    /**
     * 条件查询数据数量。
     *
     * @param entity 条件
     * @return count
     */
    Mono<Long> count(T entity);


    /**
     * 条件查询列表。
     *
     * @param entity 条件
     * @return list
     */
    Flux<T> findList(T entity, PageableParameter pageableParameter);


    /**
     * 条件查询列表。
     *
     * @param entity 条件
     * @return list
     */
    Flux<T> findList(T entity, Pageable pageable);


}
