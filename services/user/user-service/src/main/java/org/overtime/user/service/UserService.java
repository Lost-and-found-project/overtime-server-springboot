package org.overtime.user.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.PageInfoSupport;
import org.overtime.common.Paged;
import org.overtime.user.domain.entity.User;
import org.overtime.user.domain.entity.UserWithInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User service interface.
 *
 * @author ForteScarlet
 */
public interface UserService {

    /**
     * 根据用户id查询指定用户。
     *
     * @param id id
     * @return user
     */
    Mono<User> findById(@NotNull Long id);


    /**
     * 根据用户参数查询用户列表。
     *
     * @param user user
     * @return users
     */
    Flux<User> findAll(@Nullable User user);


    /**
     * 查询用户分页信息
     *
     * @param user     user
     * @param pageInfo pageInfo
     * @return paged user
     */
    Mono<Paged<User>> findAllPaged(User user, PageInfoSupport pageInfo);


    /**
     * 条件查询分页后的数据列。
     *
     * @param user     query param
     * @param pageInfo page info
     * @return paged user list
     */
    Flux<User> findAllPagedList(User user, PageInfoSupport pageInfo);


    /**
     * 查询数量。
     * @param user query param. 如果为null则查询总数。
     * @return count
     */
    Mono<Long> count(@Nullable User user);


    /**
     * 根据ID查询用户信息，并携带用户基本信息。
     *
     * @param id id
     * @return user with user info.
     */
    Mono<UserWithInfo> findUserWithInfoById(Long id);
}
