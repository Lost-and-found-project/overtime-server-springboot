package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminUserRepository extends R2dbcRepository<AdminUser, Integer> {
}
