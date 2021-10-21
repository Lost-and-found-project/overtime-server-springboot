package org.overtime.admin.bean.vo;

import java.util.List;

/**
 * 所有的角色、权限、路由。
 * 一般用于查询条件。
 *
 * @author ForteScarlet
 */
public record AdminUserListQueryParamVO(
        List<RoleVO> roles,
        List<AuthVO> auths,
        List<RouteVO> routes
) {
}
