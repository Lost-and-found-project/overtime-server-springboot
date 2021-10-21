package org.overtime.admin.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 *
 * 管理账号。
 * // Authorization
 * @author ForteScarlet
 */
@Data
@Table("admin_user")
public class AdminUser {
    /**
     * Id.
     */
    @Id
    private Integer id;
    /**
     * 登录用户名。
     */
    private Long username;
    /**
     * 登录密码。
     */
    private Long password;
    /**
     * 账号创建时间。
     */
    private LocalDateTime createTime;
    /**
     * 状态。
     */
    private Integer status;

}
