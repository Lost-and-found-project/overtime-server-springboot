package org.overtime.admin.bean.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.Value;
import org.overtime.common.domain.View;

/**
 *
 *
 *
 * id ID
 * username 登录用户名。不可重复，只能是英文
 * password 登录密码。考虑加密
 * createTime 创建时间
 * status 状态码。-1：停用，0：正常
 *        用户的过期状态在查询的时候进行检测与设置。
 *
 *
 *
 */
@Value
public class AdminUserWithRoleWithAuthWithRoute implements View {
    /**
     * ID
     */
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private Date createTime;

    /**
     *
     *
     */
    private Short status;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 角色名称，不可重复
     */
    private String roleName;

    /**
     * 创建日期
     */
    private Date roleCreateTime;

    /**
     * 权限ID
     */
    private Integer authId;

    /**
     * 权限key，应该为全英文，不可重复
     */
    private String authKey;

    /**
     * 权限描述名称
     */
    private String authName;

    /**
     * 创建时间
     */
    private Date authCreateTime;

    /**
     * 路由ID
     */
    private Integer routeId;

    /**
     * 路由的路径。不可重复
     */
    private String route;

    /**
     * 创建时间
     */
    private Date routeCreateTime;

    @Serial
    private static final long serialVersionUID = 1L;
}

