package org.overtime.admin.service;

import org.overtime.admin.bean.domain.AdminUser;
import org.overtime.admin.bean.dto.AdminUserListQueryDTO;
import org.overtime.admin.bean.vo.AdminUserListQueryParamVO;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理用户服务接口。
 * @author ForteScarlet
 */
public interface AdminUserService {

    /**
     * 获取所有的角色、权限、路由信息。
     */
    Mono<AdminUserListQueryParamVO> getUserListQueryParam();

    /**
     * 根据参数查询用户列表
     * @param queryDTO params
     * @return Page AdminUser
     */
    Flux<AdminUser> queryUserPaged(AdminUserListQueryDTO queryDTO);
}
