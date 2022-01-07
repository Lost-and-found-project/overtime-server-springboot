package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.admin.repository.AdminAuthRepository;
import org.overtime.admin.service.AdminAuthService;
import org.overtime.admin.service.AdminRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

/**
 * @author ForteScarlet
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminAuthServiceImpl extends StandardBaseService<AdminAuth, Integer, AdminAuthRepository> implements AdminAuthService {
    private final AdminRouteService routeService;

    @Override
    public Flux<AdminAuth> findAuthsByRoleId(int roleId) {
        return getRepository().findAuthsByRoleId(roleId);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Flux<AdminAuth> findAuthsFullByRoleId(int roleId) {
        return findAuthsByRoleId(roleId).flatMap(auth ->
                routeService.findRoutesByAuthIdWithChildren(auth.getId())
                        .collectList().map(routes -> {
                            auth.setRoutes(routes);
                            return auth;
                        }));
    }

    @Override
    protected @NotNull Class<AdminAuth> entityType() {
        return AdminAuth.class;
    }
}
