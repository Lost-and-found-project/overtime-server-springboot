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

}