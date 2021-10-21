package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminRole;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色repo
 * @author ForteScarlet
 */
@Repository
public interface AdminRoleRepository extends StandardOvertimeRepository<AdminRole, Integer> {
}
