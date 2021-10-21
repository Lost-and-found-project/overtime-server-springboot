package org.overtime.admin.repository;

import org.overtime.admin.bean.domain.AdminUser;
import org.overtime.admin.bean.dto.AdminUserListQueryDTO;
import org.overtime.common.repository.StandardOvertimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户repo
 *
 *
 *
 * @author ForteScarlet
 */
@Repository
public interface AdminUserRepository extends StandardOvertimeRepository<AdminUser, Integer> {

    // QuerydslPredicateExecutor

    @Query("SELECT * FROM admin_user LIMIT :offset, :size")
    Flux<AdminUser> selectAdminUser(@Param("offset") Long offset, @Param("size") Integer size);
    // Flux<AdminUser> selectAdminUser(@Param("offset") Long offset, @Param("size") Integer size);

}
