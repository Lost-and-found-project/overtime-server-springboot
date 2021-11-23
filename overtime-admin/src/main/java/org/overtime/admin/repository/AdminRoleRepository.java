package org.overtime.admin.repository;

import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.Query;
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
    @Query("SELECT id, name, create_time FROM admin_role")
    <S> Flux<S> findAllForQueryParam(Class<S> type);

}
