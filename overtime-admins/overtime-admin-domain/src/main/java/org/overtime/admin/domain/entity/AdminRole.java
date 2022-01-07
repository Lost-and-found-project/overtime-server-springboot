package org.overtime.admin.domain.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.overtime.common.auth.RoleInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理角色。
 *
 * @author ForteScarlet
 */
@Table("admin_role")
@Data
@ApiModel("管理角色")
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

    @Transient
    private List<AdminAuth> auths;
}
