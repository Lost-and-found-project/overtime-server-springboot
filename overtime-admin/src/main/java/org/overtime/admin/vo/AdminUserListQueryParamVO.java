package org.overtime.admin.vo;

import org.overtime.admin.domain.AdminAuth;
import org.overtime.admin.domain.AdminRole;
import org.overtime.admin.domain.AdminRoute;

import java.util.List;

/**
 * 所有的角色、权限、路由。
 * 一般用于查询条件。
 *
 * @author ForteScarlet
 */
public record AdminUserListQueryParamVO(
        List<AdminRole> roles,
        List<AdminAuth> auths,
        List<AdminRoute> routes
) {
}
