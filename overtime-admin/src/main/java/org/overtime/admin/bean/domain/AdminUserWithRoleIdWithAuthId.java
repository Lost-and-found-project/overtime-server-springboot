package org.overtime.admin.bean.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.overtime.common.domain.View;

@Data
public class AdminUserWithRoleIdWithAuthId implements View {
    /**
     * ID
     */
    private Integer id;

    /**
     * 登录用户名。不可重复，只能是英文
     */
    private String username;

    /**
     * 登录密码。考虑加密
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态码。-1：停用，0：正常
     * 用户的过期状态在查询的时候进行检测与设置。
     */
    private Short status;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 权限ID
     */
    private Integer authId;

    @Serial
    private static final long serialVersionUID = 1L;
}

