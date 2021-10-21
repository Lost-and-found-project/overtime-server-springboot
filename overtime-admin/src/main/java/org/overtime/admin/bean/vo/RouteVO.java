package org.overtime.admin.bean.vo;

import org.overtime.admin.bean.domain.AdminRoute;

/**
 * @author ForteScarlet
 */
public record RouteVO(Integer id, String route) {
    public static RouteVO byRoute(AdminRoute route) {
        return new RouteVO(route.id(), route.route());
    }
}
