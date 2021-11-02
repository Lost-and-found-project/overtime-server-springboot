package org.overtime.common.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Getter
    private final REP repository;

    @Getter
    @Autowired
    private OvertimeR2dbcEntityTemplate overtimeR2dbcEntityTemplate;

    public StandardR2dbcService(REP repository) {
        this.repository = repository;
    }


    ///////

    public void setOvertimeR2dbcEntityTemplate(OvertimeR2dbcEntityTemplate overtimeR2dbcEntityTemplate) {
        if (this.overtimeR2dbcEntityTemplate == null) {
            throw new UnsupportedOperationException("overtimeR2dbcEntityTemplate has already init.");
        }
        this.overtimeR2dbcEntityTemplate = overtimeR2dbcEntityTemplate;
    }

}
