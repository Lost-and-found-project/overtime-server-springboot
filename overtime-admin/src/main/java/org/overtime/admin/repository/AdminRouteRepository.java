package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminRoute;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * 路由repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminRouteRepository extends StandardOvertimeRepository<AdminRoute, Integer> {
    /**
     * Find all.
     *
     * @param type type
     * @return all
     */
    @Query("SELECT id, route, create_time FROM admin_route")
    <S> Flux<S> findAll(Class<S> type);

}
