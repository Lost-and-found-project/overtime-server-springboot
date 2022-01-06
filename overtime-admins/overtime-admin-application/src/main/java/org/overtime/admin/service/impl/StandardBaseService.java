package org.overtime.admin.service.impl;

import org.jetbrains.annotations.NotNull;
import org.overtime.admin.service.BaseService;
import org.overtime.common.domain.PageableParameter;
import org.overtime.common.service.StandardR2dbcService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.io.Serializable;

/**
 * @author ForteScarlet
 */
public abstract class StandardBaseService<T, ID extends Serializable, REP extends R2dbcRepository<T, ID>>
        extends StandardR2dbcService<T, ID, REP> implements BaseService<T> {

    /**
     * 得到当前实体类的对应类型。
     *
     * @return class
     */
    @NotNull
    protected abstract Class<T> entityType();

    @Override
    public Flux<T> findList(T entity, PageableParameter pageableParameter) {
        return findList(entity, pageableParameter.pageable());
    }

    @Override
    public Flux<T> findList(T entity, Pageable pageable) {
        return pagedList(entity, entityType(), pageable);
    }


}
