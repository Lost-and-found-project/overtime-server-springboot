package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.admin.bean.param.AdminUserListQueryParam;
import org.overtime.admin.bean.param.AdminUserRoleEditParam;
import org.overtime.admin.bean.vo.AdminUserHidePassVO;
import org.overtime.admin.bean.vo.AdminUserListQueryParamVO;
import org.overtime.admin.service.AdminUserService;
import org.overtime.common.Paged;
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
@RequestMapping("/admin/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserController {
    private final AdminUserService adminUserService;

    /**
     * 获取列表查询参数。
     */
    @GetMapping("/listQueryParam")
    public Mono<AdminUserListQueryParamVO> getListQueryParam() {
        return adminUserService.getUserListQueryParam();
    }


    /**
     * 查询用户分页列表。
     * @param queryDTO dto
     * @return AdminUserHidePassVO paged.
     */
    @GetMapping("/page")
    public Mono<Paged<AdminUserHidePassVO>> queryUser(AdminUserListQueryParam queryDTO) {
        return adminUserService.queryUserPaged(queryDTO);
    }


    /**
     * 为某个用户设置部分管理角色
     */
    @PostMapping("/addRole")
    public Flux<Integer> addRole(@RequestBody AdminUserRoleEditParam param) {
        return adminUserService.addRole(param);
    }


    /**
     * 为某个用户移除部分管理角色
     */
    @PostMapping("/removeRole")
    public Flux<Integer> removeRole(@RequestBody AdminUserRoleEditParam param) {
        return adminUserService.removeRole(param);
    }



}
