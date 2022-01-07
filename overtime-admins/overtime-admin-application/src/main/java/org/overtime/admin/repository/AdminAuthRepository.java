package org.overtime.admin.repository;

import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 权限repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminAuthRepository extends StandardOvertimeRepository<AdminAuth, Integer> {
    /**
     * Find all.
     *
     * @param type type
     * @return all
     */
    @Query("SELECT id, `key`, name, create_time FROM overtime_management.admin_auth")
    <S> Flux<S> findAllForQueryParam(Class<S> type);

    /**
     * 根据role id查询所有的权限列表
     *
     * @param roleId roleId
     * @return auth
     */
    @Query("""
            SELECT * FROM overtime_management.admin_auth aa
            LEFT JOIN overtime_management.admin_role_auth ara on aa.id = ara.auth_id
            WHERE role_id = :roleId
            """)
    Flux<AdminAuth> findAuthsByRoleId(int roleId);

    /**
     * 根据role id删除所有的权限列表
     *
     * @param id id
     * @return updated
     */
    @Modifying
    @Query("""
            DELETE FROM overtime_management.admin_role_auth
            WHERE role_id = :id
            """)
    Mono<Integer> deleteAllByRoleId(int id);

    /**
     * 记录一条角色对应权限信息
     * @param roleId role id
     * @param authId auth id
     * @return updated
     */
    @Modifying
    @Query("""
                INSERT INTO overtime_management.admin_role_auth(role_id, auth_id)
                VALUE (:roleId, :authId)
            """)
    Mono<Integer> saveRoleAuth(int roleId, Integer authId);
}
