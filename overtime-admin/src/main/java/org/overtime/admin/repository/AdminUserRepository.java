package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminUser;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminUserRepository extends StandardOvertimeRepository<AdminUser, Integer> {

}
