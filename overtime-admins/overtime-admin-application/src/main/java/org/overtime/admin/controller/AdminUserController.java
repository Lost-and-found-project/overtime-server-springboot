package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import org.oertime.admin.api.AdminUserApi;
import org.overtime.admin.domain.entity.AdminUser;
import org.overtime.admin.service.AdminUserService;
import org.overtime.common.domain.PageableParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Admin user controller.
 *
 * @author ForteScarlet
 */
@RestController
@RequestMapping(AdminUserApi.API_REQ_MAPPING)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserController implements AdminUserApi {
    private final AdminUserService adminUserService;

    /**
     * 根据ID查询管理员用户。
     *
     * @param id id
     * @return admin user
     */
    @Override
    @GetMapping(FIND_BY_ID)
    public Mono<AdminUser> findById(@PathVariable("id") int id) {
        return adminUserService.findById(id);
    }

    /**
     * 根据ID查询管理员用户的完整信息。
     *
     * @param id id
     * @return admin user
     */
    @GetMapping(FIND_FULL_BY_ID)
    @Override
    public Mono<AdminUser> findFullById(@PathVariable int id) {
        return adminUserService.findUserFullInfoById(id);
    }

    /**
     * 根据唯一用户名查询管理员账号信息。
     *
     * @param username username
     * @return admin user
     */
    @GetMapping(FIND_BY_USERNAME)
    @Override
    public Mono<AdminUser> findByUsername(@PathVariable("username") String username) {
        return adminUserService.findByUsername(username);
    }


    /**
     * 根据条件查询用户总数量。
     *
     * @param adminUser admin user query param
     * @return count
     */
    @GetMapping(COUNT)
    @Override
    public Mono<Long> count(AdminUser adminUser) {
        return adminUserService.count(adminUser);
    }


    /**
     * 根据条件查询用户数据。
     * 可以提供offset和limit。
     *
     * @param adminUser         查询条件
     * @param pageableParameter 分页相关的信息
     * @return 用户数据。
     */
    @GetMapping(LIST)
    @Override
    public Flux<AdminUser> list(AdminUser adminUser, PageableParameter pageableParameter) {
        return adminUserService.findList(adminUser, pageableParameter);
    }


    /**
     * 新增一个用户。
     *
     * @param user user
     * @return user
     */
    @PostMapping
    public Mono<AdminUser> createUser(@RequestBody AdminUser user) {
        return adminUserService.createUser(user);
    }

}
