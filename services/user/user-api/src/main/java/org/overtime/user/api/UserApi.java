package org.overtime.user.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.Paged;
import org.overtime.user.domain.entity.User;
import org.overtime.user.domain.entity.UserWithInfo;
import org.overtime.user.domain.param.UserPagedParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 对外的用户服务API。
 *
 * @author ForteScarlet
 */
@ReactiveFeignClient(UserApiConstant.USER_SERVICE)
public interface UserApi {
    String API_REQ_MAPPING = "/user";



    String FIND_USER_BY_ID = "/id/{id}";

    /**
     * 根据ID查询指定用户。
     *
     * @param id id
     * @return user
     */
    @GetMapping(FIND_USER_BY_ID)
    Mono<User> findUserById(@NotNull @PathVariable("id") Long id);



    String FIND_USER_BY_ID_WITH_INFO = "/detail/id/{id}";

    /**
     * 根据用户ID查询详情，并携带用户信息。
     * @param id id
     * @return user with user info.
     */
    @GetMapping(FIND_USER_BY_ID_WITH_INFO)
    Mono<UserWithInfo> findUserByIdWithInfo(@PathVariable("id") Long id);

    String ALL = "/all";

    /**
     * Post根据参数直接获取所有用户。
     *
     * @return users
     */
    @PostMapping(ALL)
    Flux<User> all(@Nullable @RequestBody User user);


    String PAGED = "/paged";

    /**
     * 根据查询条件分页查询用户信息。
     *
     * @param userPagedParam userPagedParam
     * @return user paged.
     */
    @PostMapping(PAGED)
    Mono<Paged<User>> paged(@RequestBody UserPagedParam userPagedParam);


    String PAGED_LIST = "/pagedList";

    /**
     * 查询分页后的数据列表。
     * @param userPagedParam param
     * @return user paged list.
     */
    @PostMapping(PAGED_LIST)
    Flux<User> pagedList(@RequestBody UserPagedParam userPagedParam);


    String COUNT = "/count";

    @GetMapping(COUNT)
    Mono<Long> count(@RequestBody @Nullable User user);


}
