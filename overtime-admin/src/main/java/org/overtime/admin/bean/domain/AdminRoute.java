package org.overtime.admin.bean.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理权限的路由信息
 *
 * @author ForteScarlet
 */
@Table("admin_route")
public record AdminRoute(
        @Id Integer id,
        String route,
        LocalDateTime create_time
) {
}
