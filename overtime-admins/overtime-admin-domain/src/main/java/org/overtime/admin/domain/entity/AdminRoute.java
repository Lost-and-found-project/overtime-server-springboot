package org.overtime.admin.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.auth.RouteInfo;
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
@ApiModel("管理系统路由")
public class AdminRoute implements RouteInfo {
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

    @Override
    public boolean checkRoute(String route) {
        if (this.route == null) {
            return false;
        }

        return this.route.equals(route);
    }
}
