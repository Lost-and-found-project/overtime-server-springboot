package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminUser;
import org.overtime.admin.bean.param.AdminUserRoleEditParam;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminUserRepository extends StandardOvertimeRepository<AdminUser, Integer> {

    @Modifying
    @Query("INSERT INTO admin_user_role(user_id, role_id) value (:userId, :roleId)")
    Mono<Void> addAdminUserRole(int userId, int roleId);


    @Query("SELECT role_id FROM admin_user_role WHERE user_id = :userId")
    Flux<Integer> getUserRolesId(@Param("userId") Integer userId);

}
