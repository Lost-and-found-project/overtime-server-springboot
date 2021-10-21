package org.overtime.admin.service;

import org.overtime.admin.vo.AdminUserListQueryParamVO;
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

}
