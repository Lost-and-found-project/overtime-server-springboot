package org.overtime.common.repository;

import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.NoRepositoryBean;
import reactor.core.publisher.Flux;

import java.io.Serializable;

/**
 * 标准的仓库接口，继承 {@link org.springframework.data.r2dbc.repository.R2dbcRepository}
 * // ReactiveQuerydslPredicateExecutor<T>
 * <p>
 * ReactiveQuerydslPredicateExecutor see :
 * <ul>
 *     <li>https://docs.spring.io/spring-data/r2dbc/docs/1.3.5/reference/html/#core.extensions</li>
 *     <li>https://querydsl.com/</li>
 * </ul>
 * </p>
 *
 * @author ForteScarlet
 * @see R2dbcRepository
 * @see ReactiveQuerydslPredicateExecutor
 */
@NoRepositoryBean
public interface StandardOvertimeRepository<T, ID extends Serializable> extends R2dbcRepository<T, ID> {


}
