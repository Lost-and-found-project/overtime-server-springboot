package org.overtime.admin.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 管理权限的路由信息
 *
 * @author ForteScarlet
 */
@Table("admin_route")
public record AdminRoute(
        @Id Integer id,
        String route
) {
}
