package org.overtime.service;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.io.Serializable;

/**
 *
 * 针对于 服务({@code Service}) 的标准抽象父类，提供部分常规方法。
 *
 * 通过构造得到 {@link #getRepository()} 所需的 {@code repository} 实例。
 *
 * @author ForteScarlet
 */
public abstract class StandardReactiveCrudService<T, ID extends Serializable, REP extends ReactiveCrudRepository<T, ID>> extends BaseReactiveCrudService<T, ID, REP> {
    private final REP repository;

    protected StandardReactiveCrudService(REP repository) {
        this.repository = repository;
    }

    @Override
    protected REP getRepository() {
        return repository;
    }

}
