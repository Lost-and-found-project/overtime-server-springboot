package org.overtime.admin.domain.entity;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理权限的路由信息
 *
 * @author ForteScarlet
 */
@Data
@Table("admin_route")
public class AdminRoute {
    @Id
    private Integer id;
    @Nullable
    private Integer parentId;

    private String route;
    private String description;
    private LocalDateTime createTime;

    @Transient
    @Nullable
    private List<AdminRoute> children;


    public void setChildren(@Nullable List<AdminRoute> children) {
        // if (children != null) {
        //     for (AdminRoute child : children) {
        //     }
        // }
        this.children = children;
    }
}
