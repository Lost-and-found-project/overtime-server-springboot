package org.oertime.admin.api;

import org.overtime.admin.domain.entity.AdminUser;
import org.overtime.common.ServiceConstant;
import org.overtime.common.domain.PageableParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理员信息查询api
 *
 * @author ForteScarlet
 */
@ReactiveFeignClient(value = ServiceConstant.ADMIN_SERVICE, path = AdminUserApi.API_REQ_MAPPING)
public interface AdminUserApi {
    String API_REQ_MAPPING = "/admin/user";


    String FIND_BY_ID = "/id/{id}";

    /**
     * 根据ID查询管理员用户。
     *
     * @param id id
     * @return admin user
     */
    @GetMapping(FIND_BY_ID)
    Mono<AdminUser> findById(@PathVariable("id") int id);


    String FIND_BY_USERNAME = "/username/{username}";

    /**
     * 根据唯一用户名查询管理员账号信息。
     *
     * @param username username
     * @return admin user
     */
    @GetMapping(FIND_BY_USERNAME)
    Mono<AdminUser> findByUsername(@PathVariable("username") String username);


    String COUNT = "/count";

    /**
     * 根据条件查询用户总数量。
     *
     * @param adminUser admin user query param
     * @return count
     */
    @GetMapping(COUNT)
    Mono<Long> count(AdminUser adminUser);


    String LIST = "/list";

    /**
     * 根据条件查询用户数据。
     * 可以提供offset和limit。
     *
     * @param adminUser 查询条件
     * @param pageableParameter 查询参数
     * @return 用户数据。
     */
    @GetMapping(LIST)
    Flux<AdminUser> list(AdminUser adminUser, PageableParameter pageableParameter);


}
