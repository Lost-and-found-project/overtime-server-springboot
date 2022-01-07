package org.overtime.admin.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.oertime.admin.api.AdminRoleApi;
import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.admin.service.AdminRoleService;
import org.overtime.common.domain.PageableParameter;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return roleService.findById(id);
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
        return roleService.findRolesByUserId(id);
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
        return roleService.count(role);
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
        return roleService.findList(role, pageableParameter);
    }

    @ApiOperation(
            value = "新增/修改角色",
            notes = """
                    如果存在ID则为修改，否则为新增
                    如果参数中的 'auths' 不为空，则只会取auths中各对象的'id'属性，
                    并为这个用户重新设置角色信息。
                    """
    )
    @PostMapping
    public Mono<AdminRole> modifyRole(@RequestBody AdminRole role) {
        return roleService.modifyRole(role);
    }
}
