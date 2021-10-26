package org.overtime.admin.service.impl;

import org.jetbrains.annotations.Nullable;
import org.overtime.admin.bean.domain.AdminRoute;
import org.overtime.admin.repository.AdminRouteRepository;
import org.overtime.admin.service.AdminRouteService;
import org.overtime.common.service.StandardR2dbcService;
import org.overtime.common.utils.Check;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * implements for {@link org.overtime.admin.service.AdminRouteService}
 *
 * @author ForteScarlet
 */
@Service
public class AdminRouteServiceImpl extends StandardR2dbcService<AdminRoute, Integer, AdminRouteRepository> implements AdminRouteService {

    public AdminRouteServiceImpl(AdminRouteRepository repository) {
        super(repository);
    }

    @Override
    public Mono<AdminRoute> findById(Integer id, boolean full) {
        Check.requireNotnull(id, "id");

        final var repo = getRepository();
        return repo.findById(id).flatMap(route -> {
            if (full) {
                return findByParentId(route.getId(), true).collectList().map(children -> {
                    route.setChildren(children);
                    return route;
                });
            } else {
                return Mono.just(route);
            }
        });
    }

    @Override
    public Flux<AdminRoute> findByParentId(@Nullable Integer parentId, boolean full) {
        final var repo = getRepository();

        final Flux<AdminRoute> byParentId;
        if (parentId != null) {
            byParentId = repo.findByParentId(parentId);
        } else {
            byParentId = repo.findAllRoot();
        }

        return byParentId.flatMap(route -> {
            if (full) {
                return findByParentId(route.getId(), true).collectList().map(children -> {
                    route.setChildren(children);
                    return route;
                });
            } else {
                return Mono.just(route);
            }
        });
    }


}
