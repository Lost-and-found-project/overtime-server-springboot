package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.admin.bean.dto.AdminUserListQueryDTO;
import org.overtime.admin.bean.vo.AdminUserHidePassVO;
import org.overtime.admin.bean.vo.AdminUserListQueryParamVO;
import org.overtime.admin.service.AdminUserService;
import org.overtime.common.Paged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Admin user controller.
 *
 * @author ForteScarlet
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserController {
    private final AdminUserService adminUserService;

    /**
     * 获取列表查询参数。
     */
    @GetMapping("/listQueryParam")
    public Mono<AdminUserListQueryParamVO> getUserListQueryParam() {
        return adminUserService.getUserListQueryParam();
    }


    /**
     * 查询用户列表
     * @param queryDTO dto
     * @return AdminUserHidePassVO paged.
     */
    @GetMapping("/queryUser")
    public Mono<Paged<AdminUserHidePassVO>> queryUser(AdminUserListQueryDTO queryDTO) {
        return adminUserService.queryUserPaged(queryDTO);
    }

}
