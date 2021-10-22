package org.overtime.admin.bean.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.overtime.common.domain.View;

@Data
public class AdminUserWithRoleId implements View {
    /**
     * ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
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
     *
     */
    private Integer roleId;

    @Serial
    private static final long serialVersionUID = 1L;
}

