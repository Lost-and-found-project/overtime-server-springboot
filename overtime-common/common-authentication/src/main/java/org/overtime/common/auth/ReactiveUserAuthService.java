package org.overtime.common.auth;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户-角色-权限-路由相关信息获取。
 *
 * @author ForteScarlet
 */
public interface ReactiveUserAuthService {

    /**
     * 根据唯一用户名查询用户结果。
     *
     * @param username username
     * @return user info
     */
    Mono<UserInfo> getUserByUsername(String username);

    /**
     * 根据用户信息（用户名）获取角色信息。
     *
     * @param username username
     * @return roles
     */
    Flux<RoleInfo> getRolesByUsername(String username);


    /**
     * 根据角色ID查询权限信息。
     *
     * @param roleId role id
     * @return auths
     */
    Flux<AuthInfo> getAuthsByRoleId(long roleId);


    /**
     * 根据权限ID查询路由信息。
     *
     * @param authId auth id
     * @return routes
     */
    Flux<RouteInfo> getRoutesByAuthId(long authId);


}
