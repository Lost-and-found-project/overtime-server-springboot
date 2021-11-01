package org.overtime.user.api;

import org.jetbrains.annotations.NotNull;
import org.overtime.user.domain.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

/**
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




}
