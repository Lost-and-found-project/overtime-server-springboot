package org.overtime.user.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.Paged;
import org.overtime.common.PageInfoSupport;
import org.overtime.user.domain.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User service interface.
 * @author ForteScarlet
 */
public interface UserService {

    /**
     * 根据用户id查询指定用户。
     * @param id id
     * @return user 
     */
    Mono<User> findById(@NotNull Long id);


    /**
     * 根据用户参数查询用户列表。
     * @param user user
     * @return users
     */
    Flux<User> findAll(@Nullable User user);


    /**
     * 查询用户分页信息
     * @param user user
     * @param pageInfo pageInfo
     * @return
     */
    Mono<Paged<User>> findAllPaged(User user, PageInfoSupport pageInfo);

}
