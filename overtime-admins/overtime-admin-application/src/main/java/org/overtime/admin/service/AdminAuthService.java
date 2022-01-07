package org.overtime.admin.service;

import org.overtime.admin.domain.entity.AdminAuth;
import reactor.core.publisher.Flux;

/**
 * 管理角色服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminAuthService extends BaseService<AdminAuth> {

    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * @param roleId 角色id
     * @return roles
     */
    Flux<AdminAuth> findAuthsByRoleId(int roleId);

    /**
     * 根据用户ID查询其对应的角色列表。
     * <p>
     * 会填充 route 信息。
     *
     * @param roleId 角色id
     * @return roles
     */
    Flux<AdminAuth> findAuthsFullByRoleId(int roleId);

}
