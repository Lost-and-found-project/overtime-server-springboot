package org.overtime.admin.bean.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理账号。
 *
 * @param id
 * @param username
 * @param password
 * @param createTime
 * @param status
 * @author ForteScarlet
 */
@Table("admin_user")
public record AdminUser(
        @Id
        Integer id,
        String username,
        String password,
        LocalDateTime createTime,
        Short status
) {
}
