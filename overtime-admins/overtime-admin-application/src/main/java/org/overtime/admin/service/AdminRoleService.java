package org.overtime.admin.service;

import org.overtime.admin.domain.entity.AdminRole;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理角色服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminRoleService extends BaseService<AdminRole> {

    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * @param userId 用户id
     * @return roles
     */
    Flux<AdminRole> findRolesByUserId(int userId);

    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * 会填充auth信息。
     *
     * @param userId 用户id
     * @return roles
     */
    Flux<AdminRole> findFullRolesByUserId(int userId);

    /**
     * 根据用户ID设置其所有权限。会删除所有旧值并设置新值。
     * @param userId user id
     * @param roles auth ids
     * @return new roles
     */
    Flux<AdminRole> setUserRoles(int userId, Publisher<Integer> roles);

    /**
     * 新增/修改role信息
     * @param role role
     * @return new role
     */
    Mono<AdminRole> modifyRole(AdminRole role);
}
