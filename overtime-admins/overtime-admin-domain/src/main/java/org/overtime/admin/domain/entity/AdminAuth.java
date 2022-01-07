package org.overtime.admin.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jetbrains.annotations.ApiStatus;
import org.overtime.common.auth.AuthInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理权限信息
 *
 * @author ForteScarlet
 */
@Table("admin_auth")
@Data
@ApiModel("管理权限")
public class AdminAuth implements AuthInfo {
    @Id
    private Integer id;
    @ApiModelProperty("唯一KEY")
    private String key;
    @ApiModelProperty("展示名称")
    private String name;
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @Transient
    @ApiModelProperty("所持路由列表")
    private List<AdminRoute> routes;

}
