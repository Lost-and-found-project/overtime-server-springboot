package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminRoute;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * 路由repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminRouteRepository extends StandardOvertimeRepository<AdminRoute, Integer> {
}