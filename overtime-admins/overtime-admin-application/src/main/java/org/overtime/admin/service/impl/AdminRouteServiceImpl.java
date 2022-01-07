package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.admin.domain.entity.AdminRoute;
import org.overtime.admin.repository.AdminRouteRepository;
import org.overtime.admin.service.AdminRouteService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * implements for {@link org.overtime.admin.service.AdminRouteService}
 *
 * @author ForteScarlet
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminRouteServiceImpl extends StandardBaseService<AdminRoute, Integer, AdminRouteRepository> implements AdminRouteService {


    @Override
    protected @NotNull Class<AdminRoute> entityType() {
        return AdminRoute.class;
    }

    @Override
    public Flux<AdminRoute> findByParentId(int parentId) {
        return getRepository().findByParentId(parentId);
    }

    @Override
    public Flux<AdminRoute> findRoutesByAuthId(@Nullable Integer authId) {
        return getRepository().findRoutesByAuthId(authId);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Flux<AdminRoute> findRoutesByParentId(Integer parentId) {
        final AdminRouteRepository repository = getRepository();
        return repository.findByParentId(parentId).flatMap(route -> {
            final Integer id = route.getId();
            return findRoutesByParentId(id)
                    .collectList()
                    .map(children -> {
                        route.setChildren(children);
                        return route;
                    });
        }).subscribeOn(Schedulers.parallel());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Flux<AdminRoute> findRoutesByAuthIdWithChildren(@Nullable Integer authId) {
        return findRoutesByAuthId(authId)
                .flatMap(route -> findRoutesByParentId(route.getId())
                        .collectList()
                        .map(children -> {
                            route.setChildren(children);
                            return route;
                        }));
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Flux<AdminRoute> all(boolean full) {
        final Flux<AdminRoute> roots = getRepository().findAllRoot();
        if (!full) {
            return roots;
        } else {
            return roots.flatMap(route -> findRoutesByParentId(route.getId())
                    .collectList()
                    .map(children -> {
                        route.setChildren(children);
                        return route;
                    }).subscribeOn(Schedulers.parallel()));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Flux<AdminRoute> setAuthRoutes(int authId, Publisher<Integer> routeIds) {
        final var repository = getRepository();
        final Flux<Integer> newRouteIds = repository.deleteAllByAuthId(authId)
                .then()
                .flatMapMany(v ->
                        Flux.from(routeIds)
                                .flatMap(routeId -> repository.setAuthRoute(authId, routeId).map(i -> routeId))
                );

        return repository.findAllById(newRouteIds);
    }
}
