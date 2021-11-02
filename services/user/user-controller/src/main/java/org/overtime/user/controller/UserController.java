package org.overtime.user.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.Paged;
import org.overtime.user.api.UserApi;
import org.overtime.user.domain.entity.User;
import org.overtime.user.domain.entity.UserWithInfo;
import org.overtime.user.domain.param.UserPagedParam;
import org.overtime.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户相关控制器。
 *
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
    @GetMapping(FIND_USER_BY_ID)
    public Mono<User> findUserById(@NotNull @PathVariable("id") Long id) {
        return userService.findById(id);
    }


    /**
     * 根据用户ID查询详情，并携带用户信息。
     *
     * @param id id
     * @return user with user info.
     */
    @Override
    @GetMapping(FIND_USER_BY_ID_WITH_INFO)
    public Mono<UserWithInfo> findUserByIdWithInfo(@PathVariable("id") Long id) {
        return userService.findUserWithInfoById(id);
    }

    /**
     * 查询所有符合条件的用户。
     *
     * @param user user
     * @return users
     */
    @Override
    @PostMapping(ALL)
    public Flux<User> all(@Nullable @RequestBody User user) {
        return userService.findAll(user);
    }


    @Override
    @PostMapping(PAGED)
    public Mono<Paged<User>> paged(@RequestBody UserPagedParam userPagedParam) {
        return userService.findAllPaged(userPagedParam, userPagedParam);
    }

    @Override
    @PostMapping(PAGED_LIST)
    public Flux<User> pagedList(UserPagedParam userPagedParam) {
        return userService.findAllPagedList(userPagedParam, userPagedParam);
    }

    @Override
    @PostMapping(COUNT)
    public Mono<Long> count(@Nullable User user) {
        return userService.count(user);
    }
}
