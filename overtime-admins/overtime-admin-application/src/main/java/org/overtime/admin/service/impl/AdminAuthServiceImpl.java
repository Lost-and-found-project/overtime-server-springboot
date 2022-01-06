package org.overtime.admin.service.impl;

import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.admin.repository.AdminAuthRepository;
import org.overtime.admin.service.AdminAuthService;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author ForteScarlet
 */
@Service
public class AdminAuthServiceImpl extends StandardBaseService<AdminAuth, Integer, AdminAuthRepository> implements AdminAuthService {

    @Override
    public Flux<AdminAuth> findAuthsByRoleId(int roleId) {
        return getRepository().findAuthsByRoleId(roleId);
    }

    @Override
    protected @NotNull Class<AdminAuth> entityType() {
        return AdminAuth.class;
    }
}
