package org.overtime.common.service;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.io.Serializable;

/**
 * 针对于 服务({@code Service}) 的标准抽象父类，提供部分常规方法。
 * <p>
 * 通过构造得到 {@link #getRepository()} 所需的 {@code repository} 实例。
 *
 * @author ForteScarlet
 */
public abstract class StandardR2dbcService<T, ID extends Serializable, REP extends R2dbcRepository<T, ID>> extends BaseR2dbcService<T, ID, REP> {
    private final REP repository;
    public StandardR2dbcService(REP repository) {
        this.repository = repository;
    }

    @Override
    protected REP getRepository() {
        return repository;
    }

}
