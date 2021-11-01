package org.overtime.user.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.Paged;
import org.overtime.user.domain.entity.User;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 对外的用户服务API。
 * @author ForteScarlet
 */
@ReactiveFeignClient(UserApiConstant.USER_SERVICE)
public interface UserApi {
    String API_REQ_MAPPING = "/user";



    String FIND_USER_BY_ID = "/id/{id}";

    /**
     * 根据ID查询指定用户。
     * @param id id
     * @return user
     */
    @GetMapping(FIND_USER_BY_ID)
    Mono<User> findUserById(@NotNull @PathVariable("id") Long id);



    String ALL = "/all";

    /**
   Post根据参数直接获取所有用户。
     *
     * @return users
     */
    @PostMapping(ALL)
    Flux<User> all(@Nullable @RequestBody User user);


    String PAGED = "/paged";

    @PostMapping(PAGED)
    Mono<Paged<User>> paged(User user);

}
