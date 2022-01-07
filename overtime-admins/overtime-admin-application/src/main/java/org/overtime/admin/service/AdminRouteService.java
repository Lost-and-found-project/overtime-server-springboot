package org.overtime.admin.service;

import org.jetbrains.annotations.Nullable;
import org.overtime.admin.domain.entity.AdminRoute;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 路由服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminRouteService extends BaseService<AdminRoute> {

    /**
     * 根据PID查询routes
     *
     * @param parentId parent id
     * @return admin routes
     */
    Flux<AdminRoute> findByParentId(int parentId);


    /**
     * 根据auth id查询routes
     * <p>
     * routes不携带children信息。
     *
     * @param authId auth id
     * @return admin route
     */
    Flux<AdminRoute> findRoutesByAuthId(@Nullable Integer authId);

    /**
     * 根据auth id查询routes.
     * 查询的routes会携带 children 信息。
     *
     * @param authId auth id
     * @return admin route
     */
    Flux<AdminRoute> findRoutesByAuthIdWithChildren(@Nullable Integer authId);

    /**
     * 从根目录开始查询所有的route。
     *
     * @param full 是否填充children。
     * @return routes
     */
    Flux<AdminRoute> all(boolean full);


    /**
     * 重新设置权限的路由信息, 并返回修改后的路由信息。
     *
     * @param id       id
     * @param routeIds routes
     * @return new routes
     */
    Flux<AdminRoute> setAuthRoutes(int id, Publisher<Integer> routeIds);

    /**
     * 新增/修改 route 信息。
     * @param adminRoute route
     * @return new route
     */
    Mono<AdminRoute> modifyRoute(AdminRoute adminRoute);
}
