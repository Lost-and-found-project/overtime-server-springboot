package org.overtime.common.repository;

import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 标准的仓库接口，继承 {@link org.springframework.data.r2dbc.repository.R2dbcRepository} 和 {@link org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor}
 *
 * @see R2dbcRepository
 * @see ReactiveQuerydslPredicateExecutor
 *
 * @author ForteScarlet
 */
@NoRepositoryBean
public interface StandardOvertimeRepository<T, ID extends Serializable> extends R2dbcRepository<T, ID>, ReactiveQuerydslPredicateExecutor<T> {
}
