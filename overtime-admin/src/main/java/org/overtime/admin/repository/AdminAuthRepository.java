package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminAuth;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * 权限repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminAuthRepository extends StandardOvertimeRepository<AdminAuth, Integer> {
    // StandardOvertimeRepository
}
