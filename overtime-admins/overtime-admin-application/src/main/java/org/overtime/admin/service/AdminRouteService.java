package org.overtime.admin.service;

import org.jetbrains.annotations.Nullable;
import org.overtime.admin.domain.entity.AdminRoute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * 路由服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminRouteService {

    /**
     * 根据ID查询AdminRoute。
     *
     * @param id   id。不应为null。
     * @param full 是否是完整信息，即填充children。
     * @return admin route
     * @throws IllegalArgumentException id was null
     */
    Mono<AdminRoute> findById(Integer id, boolean full);


    /**
     * 根据 parent ID查询AdminRoute
     *
     * @param parentId parentId。可以为null，为null即查询root route。
     * @param full     是否填充children。
     * @return admin route
     */
    Flux<AdminRoute> findByParentId(@Nullable Integer parentId, boolean full);


    /**
     * 新增多个新的路由信息
     *
     * @param routes routes
     * @return Admin Route
     */
    Flux<AdminRoute> createRoutes(Collection<AdminRoute> routes);


    /**
     * 批量修改多个路由信息
     *
     * @param routes routes
     * @return updated.
     */
    Flux<AdminRoute> updateRoutes(Collection<AdminRoute> routes);


    /**
     * 删除多个路由。如果为根路由，将会删除下面的子路由。
     * TODO 是否约束？
     *
     * @param routeIds 路由ID列表
     * @return deleted routes.
     */
    Mono<Void> deleteRoutes(Integer... routeIds);

}
