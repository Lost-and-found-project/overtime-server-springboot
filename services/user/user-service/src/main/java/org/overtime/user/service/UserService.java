package org.overtime.user.service;

import org.jetbrains.annotations.NotNull;
import org.overtime.user.domain.entity.User;
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

}
