package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import org.oertime.admin.api.AdminRoleApi;
import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.admin.service.AdminRoleService;
import org.overtime.common.domain.PageableParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@RestController
@RequestMapping(AdminRoleApi.API_REQ_MAPPING)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminRoleController implements AdminRoleApi {

    private final AdminRoleService roleService;

    /**
     * 根据ID查询role
     *
     * @param id id
     * @return id
     */
    @GetMapping(FIND_BY_ID)
    @Override
    public Mono<AdminRole> findById(@PathVariable("id") int id) {
        return null;
    }


    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * @param id 用户id
     * @return roles
     */
    @GetMapping(FIND_ROLES_BY_USER_ID)
    @Override
    public Flux<AdminRole> findRolesByUserId(@PathVariable("id") int id) {
        return null;
    }


    /**
     * 条件查询数据数量。
     *
     * @param role 条件
     * @return count
     */
    @GetMapping(COUNT)
    @Override
    public Mono<Long> count(AdminRole role) {
        return null;
    }


    /**
     * 条件查询所有角色列表。
     *
     * @param role 角色
     * @return list
     */
    @GetMapping(FIND_LIST)
    @Override
    public Flux<AdminRole> findList(AdminRole role, PageableParameter pageableParameter) {
        return null;
    }
}
