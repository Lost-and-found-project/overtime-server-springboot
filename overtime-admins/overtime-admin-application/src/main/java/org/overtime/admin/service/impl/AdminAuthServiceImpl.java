package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.admin.domain.entity.AdminRoute;
import org.overtime.admin.repository.AdminAuthRepository;
import org.overtime.admin.service.AdminAuthService;
import org.overtime.admin.service.AdminRouteService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

    @Transactional(rollbackFor = Exception.class, readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Flux<AdminAuth> findAuthsFullByRoleId(int roleId) {
        return findAuthsByRoleId(roleId).flatMap(auth ->
                routeService.findRoutesByAuthIdWithChildren(auth.getId())
                        .collectList().map(routes -> {
                            auth.setRoutes(routes);
                            return auth;
                        }));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Flux<AdminAuth> setRoleAuths(int id, Publisher<Integer> authIds) {
        final var repository = getRepository();
        final Flux<Integer> newAuthIds = repository
                .deleteAllByRoleId(id)
                .then()
                .flatMapMany(updated -> Flux.from(authIds)
                        .flatMap(authId -> repository.saveRoleAuth(id, authId).map(v -> authId)));

        return repository.findAllById(newAuthIds);
    }

    @Override
    public Mono<AdminAuth> modifyAuth(AdminAuth auth) {
        return getRepository().save(auth).flatMap(updated -> {
            final List<AdminRoute> routes = auth.getRoutes();
            if (routes != null && routes.size() > 0) {
                final var routeIds = Flux.fromIterable(routes).map(AdminRoute::getId);
                return routeService.setAuthRoutes(updated.getId(), routeIds)
                        .collectList()
                        .map(list -> {
                            updated.setRoutes(list);
                            return updated;
                        });
            }

            return Mono.just(updated);
        });
    }

    @Override
    protected @NotNull Class<AdminAuth> entityType() {
        return AdminAuth.class;
    }
}
