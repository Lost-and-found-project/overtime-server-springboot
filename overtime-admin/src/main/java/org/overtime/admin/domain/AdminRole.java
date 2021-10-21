package org.overtime.admin.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理角色。
 * @author ForteScarlet
 */
@Data
@Table("admin_role")
public class AdminRole {
    @Id private Integer id;
    /**
     * 角色名称。
     */
    private String name;

    /**
     * 创建时间。
     */
    private LocalDateTime createTime;

    /**
     * 角色对应的权限列表。
     */
    @Transient
    private List<AdminAuth> auths;

}
