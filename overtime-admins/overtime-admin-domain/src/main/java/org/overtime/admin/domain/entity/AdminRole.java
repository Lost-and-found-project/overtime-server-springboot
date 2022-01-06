package org.overtime.admin.domain.entity;

import lombok.Data;
import org.overtime.common.auth.RoleInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理角色。
 *
 * @author ForteScarlet
 */
@Table("admin_role")
@Data
public final class AdminRole implements RoleInfo {
    @Id
    private Integer id;
    /**
     * 角色名称。
     */
    private String name;

    /**
     * 创建时间。
     */
    private LocalDateTime createTime;


}
