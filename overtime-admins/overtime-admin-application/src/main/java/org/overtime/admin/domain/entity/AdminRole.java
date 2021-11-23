package org.overtime.admin.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理角色。
 *
 * @param id
 * @param name       角色名称。
 * @param createTime 创建时间。
 * @author ForteScarlet
 */
@Table("admin_role")
public record AdminRole(
        @Id Integer id,
        String name,
        LocalDateTime createTime
) {
}
