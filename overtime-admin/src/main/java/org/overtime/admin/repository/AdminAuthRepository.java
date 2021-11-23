package org.overtime.admin.repository;

import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

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
    @Query("SELECT id, `key`, name, create_time FROM admin_auth")
    <S> Flux<S> findAllForQueryParam(Class<S> type);
}
