package org.overtime.admin.service;

import org.jetbrains.annotations.Nullable;
import org.overtime.admin.domain.entity.AdminRoute;
import reactor.core.publisher.Flux;

/**
 * 路由服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminRouteService extends BaseService<AdminRoute> {

    /**
     * 根据auth id查询routes
     *
     * @param authId auth id
     * @return admin route
     */
    Flux<AdminRoute> findRoutesByAuthId(@Nullable Integer authId);

}
