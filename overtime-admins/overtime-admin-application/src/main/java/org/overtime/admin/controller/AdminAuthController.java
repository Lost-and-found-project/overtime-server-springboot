package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import org.oertime.admin.api.AdminAuthApi;
import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.admin.service.AdminAuthService;
import org.overtime.common.domain.PageableParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 权限相关控制器
 * @author ForteScarlet
 */
@RestController
@RequestMapping(AdminAuthApi.API_REQ_MAPPING)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminAuthController implements AdminAuthApi {

    private final AdminAuthService authService;


    /**
     * 根据ID查询role
     *
     * @param id id
     * @return id
     */
    @GetMapping(FIND_BY_ID)
    @Override
    public Mono<AdminAuth> findById(@PathVariable int id) {
        return authService.findById(id);
    }


    /**
     * 根据角色ID查询其对应的权限列表。
     *
     * @param id 用户id
     * @return roles
     */
    @GetMapping(FIND_AUTHS_BY_ROLE_ID)
    @Override
    public Flux<AdminAuth> findAuthByRoleId(@PathVariable int id) {
        return authService.findAuthsByRoleId(id);
    }

    /**
     * 条件查询数据数量。
     *
     * @param auth 条件
     * @return count
     */
    @GetMapping(COUNT)
    @Override
    public Mono<Long> count(AdminAuth auth) {
        return authService.count(auth);
    }


    /**
     * 条件查询所有权限列表。
     *
     * @param auth 条件
     * @return list
     */
    @GetMapping(FIND_LIST)
    @Override
    public Flux<AdminAuth> findList(AdminAuth auth, PageableParameter pageableParameter) {
        return authService.findList(auth, pageableParameter);
    }
}
