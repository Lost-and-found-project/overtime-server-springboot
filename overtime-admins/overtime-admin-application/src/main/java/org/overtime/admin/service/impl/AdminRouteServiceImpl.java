package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.admin.domain.entity.AdminRoute;
import org.overtime.admin.repository.AdminRouteRepository;
import org.overtime.admin.service.AdminRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

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
    public Flux<AdminRoute> findRoutesByAuthId(@Nullable Integer authId) {
        return getRepository().findRoutesByAuthId(authId);
    }


}
