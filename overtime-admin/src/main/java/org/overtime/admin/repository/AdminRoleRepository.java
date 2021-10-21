package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminRole;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色repo
 * @author ForteScarlet
 */
@Repository
public interface AdminRoleRepository extends R2dbcRepository<AdminRole, Integer> {
}
