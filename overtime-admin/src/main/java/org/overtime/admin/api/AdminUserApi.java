package org.overtime.admin.api;

import org.jetbrains.annotations.Nullable;
import org.overtime.admin.domain.entity.AdminUser;
import org.overtime.common.ServiceConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@ReactiveFeignClient(value = ServiceConstant.ADMIN_SERVICE, path = AdminUserApi.API_REQ_MAPPING)
public interface AdminUserApi {
    String API_REQ_MAPPING = "/admin/user";


    String FIND_USER_BY_ID = "/id/{id}";

    /**
     * 根据ID查询管理员用户。
     *
     * @param id id
     * @return admin user
     */
    @GetMapping(FIND_USER_BY_ID)
    Mono<AdminUser> findUserById(@PathVariable("id") int id);


    String FIND_USER_BY_USERNAME = "/username/{username}";

    /**
     * 根据唯一用户名查询管理员账号信息。
     *
     * @param username username
     * @return admin user
     */
    @GetMapping(FIND_USER_BY_USERNAME)
    Mono<AdminUser> findUserByUsername(@PathVariable("username") String username);


    String COUNT = "/count";

    /**
     * 根据条件查询用户总数量。
     *
     * @param adminUser admin user query param
     * @return count
     */
    @GetMapping(COUNT)
    Mono<Integer> count(AdminUser adminUser);


    String LIST = "/list";

    /**
     * 根据条件查询用户数据。
     * 可以提供offset和limit。
     *
     * @param adminUser 查询条件
     * @param full      是否查询全量数据
     * @param limit     最大取的数据量
     * @param offset    初始偏移量
     * @return 用户数据。
     */
    @GetMapping(LIST)
    Flux<AdminUser> list(AdminUser adminUser,
                         @RequestParam(value = "full", defaultValue = "false")
                                 Boolean full,
                         @RequestParam(defaultValue = "0") @Nullable
                                 Integer offset,
                         @RequestParam(defaultValue = "10") @Nullable
                                 Integer limit);


}
