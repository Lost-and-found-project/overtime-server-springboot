package org.overtime.user.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.Paged;
import org.overtime.user.api.UserApi;
import org.overtime.user.domain.entity.User;
import org.overtime.user.domain.param.UserPagedParam;
import org.overtime.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户相关控制器。
 * @author ForteScarlet
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(UserApi.API_REQ_MAPPING)
public class UserController implements UserApi {

    private final UserService userService;

    /**
     * 根据ID查询指定用户。
     *
     * @param id id
     * @return user
     */
    @Override
    @RequestMapping(UserApi.FIND_USER_BY_ID)
    public Mono<User> findUserById(@NotNull @PathVariable("id") Long id) {
        return userService.findById(id);
    }

    /**
     * 查询所有符合条件的用户。
     * @param user user
     * @return users
     */
    @Override
    public Flux<User> all(@Nullable User user) {
        return userService.findAll(user);
    }



    @Override
    public Mono<Paged<User>> paged(UserPagedParam userPagedParam) {
        return null;
    }
}
