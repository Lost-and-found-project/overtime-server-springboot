package org.overtime.admin.repository;

import org.overtime.admin.domain.entity.AdminRoute;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 路由repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminRouteRepository extends StandardOvertimeRepository<AdminRoute, Integer> {
    /**
     * Find all for Query param.
     *
     * @param type type
     * @return all
     */
    @Query("""
            SELECT id, parent_id, route, create_time
            FROM overtime_management.admin_route
            """)
    <S> Flux<S> findAllForQueryParam(Class<S> type);


    @Query("""
            SELECT id, parent_id, route, create_time
            FROM overtime_management.admin_route
            WHERE parent_id IS NULL
            """)
    Flux<AdminRoute> findAllRoot();


    @Query("""
            SELECT id, parent_id, route, create_time
            FROM overtime_management.admin_route
            WHERE parent_id = :parentId
            """)
    Flux<AdminRoute> findByParentId(int parentId);

    @Query("""
            SELECT ar.* FROM overtime_management.admin_route ar
            LEFT JOIN overtime_management.admin_auth_route aar ON ar.id = aar.route_id
            WHERE aar.auth_id = :authId
            """)
    Flux<AdminRoute> findRoutesByAuthId(Integer authId);

    /**
     * 根据 auth id 删除所有关联信息。
     *
     * @param authId auth id
     * @return updated
     */
    @Modifying
    @Query("""
            DELETE FROM overtime_management.admin_auth_route
            WHERE auth_id = :authId
            """)
    Mono<Integer> deleteAllByAuthId(int authId);

    /**
     * 设置权限的路由信息。
     *
     * @param authId  auth id
     * @param routeId route id
     * @return updated
     */
    @Modifying
    @Query("""
            INSERT INTO overtime_management.admin_auth_route(auth_id, route_id)
            VALUE (:authId, :routeId)
            """)
    Mono<Integer> setAuthRoute(int authId, int routeId);
}
