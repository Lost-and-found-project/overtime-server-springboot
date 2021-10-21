package org.overtime.admin.repository;

import org.overtime.admin.domain.AdminAuth;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * 权限repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminAuthRepository extends R2dbcRepository<AdminAuth, Integer> {
}
