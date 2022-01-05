package org.overtime.admin.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理账号。
 *
 * @author ForteScarlet
 */
@Table("admin_user")
@Data
public final class AdminUser {
    @Id
    private Integer id;
    private String username;
    private String password;
    private LocalDateTime createTime;
    private Short status;

}
