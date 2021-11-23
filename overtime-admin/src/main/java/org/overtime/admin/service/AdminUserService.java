package org.overtime.admin.service;

import org.overtime.admin.domain.param.AdminUserListQueryParam;
import org.overtime.admin.domain.param.AdminUserRoleEditParam;
import org.overtime.admin.domain.vo.AdminUserHidePassVO;
import org.overtime.admin.domain.vo.AdminUserListQueryParamVO;
import org.overtime.common.Paged;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理用户服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminUserService {

    /**
     * 获取所有的角色、权限、路由信息。
     */
    Mono<AdminUserListQueryParamVO> getUserListQueryParam();

    /**
     * 根据参数查询用户列表
     *
     * @param queryDTO params
     * @return Page AdminUser
     */
    Mono<Paged<AdminUserHidePassVO>> queryUserPaged(AdminUserListQueryParam queryDTO);

    /**
     * 增加管理用户的角色，返回增加后的角色ID列表。
     *
     * @param param param
     * @return ids
     */
    Flux<Integer> addRole(AdminUserRoleEditParam param);


    /**
     * 移除管理用户的角色，返回移除后的角色ID列表。
     *
     * @param param param
     * @return ids
     */
    Flux<Integer> removeRole(AdminUserRoleEditParam param);
}
