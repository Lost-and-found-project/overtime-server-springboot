package org.overtime.admin.bean.vo;

import org.overtime.admin.bean.domain.AdminAuth;
import org.overtime.admin.bean.domain.AdminRole;
import org.overtime.admin.bean.domain.AdminRoute;

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
