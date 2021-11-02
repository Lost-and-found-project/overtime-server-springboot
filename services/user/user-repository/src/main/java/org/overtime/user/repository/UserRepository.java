package org.overtime.user.repository;

import org.overtime.common.repository.StandardOvertimeRepository;
import org.overtime.user.domain.entity.User;
import org.overtime.user.domain.entity.UserWithInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User repository
 *
 * @author ForteScarlet
 */
@Repository
public interface UserRepository extends StandardOvertimeRepository<User, Long> {



    /**
     * 根据ID查询用户，同时查询用户详情.
     * @param id ID
     * @return user with user info.
     */
    @Query("""
    SELECT ou.id, ou.username, ou.password, ou.create_time, ou.status, ou.is_admin,
    oui.id, user_id, oui.email, phone
    FROM ov_user ou
    LEFT JOIN ov_user_info oui on ou.id = oui.user_id
    WHERE ou.id = :id
    """)
    Mono<UserWithInfo> findByIdWithInfo(@Param("id") Long id);


}
