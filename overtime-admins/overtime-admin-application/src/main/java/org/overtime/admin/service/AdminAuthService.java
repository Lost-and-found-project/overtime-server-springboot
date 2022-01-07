package org.overtime.admin.service;

import org.overtime.admin.domain.entity.AdminAuth;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    /**
     * 重新设置某角色的权限列表, 并返回新的完整的权限列表。
     * @param id id
     * @param authIds auth ids
     * @return new auths
     */
    Flux<AdminAuth> setRoleAuths(int id, Publisher<Integer> authIds);

    /**
     * 新增/修改auth
     * @param auth auth
     * @return updated
     */
    Mono<AdminAuth> modifyAuth(AdminAuth auth);
}
