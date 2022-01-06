package org.overtime.admin.repository;

import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * 角色repo
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminRoleRepository extends StandardOvertimeRepository<AdminRole, Integer> {

    /**
     * Find all.
     *
     * @param type type
     * @return all
     */
    @Query("SELECT id, name, create_time FROM overtime_management.admin_role")
    <S> Flux<S> findAllForQueryParam(Class<S> type);

    @Query("""
            SELECT ar.* FROM overtime_management.admin_role ar\040
            LEFT JOIN overtime_management.admin_user_role aur on ar.id = aur.role_id
            WHERE aur.user_id = :userId
            """)
    Flux<AdminRole> findAllByUserId(int userId);

}
