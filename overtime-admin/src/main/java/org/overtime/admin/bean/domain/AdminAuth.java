package org.overtime.admin.bean.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理权限信息
 *
 * @author ForteScarlet
 */
@Table("admin_auth")
public record AdminAuth(
        @Id Integer id,
        String key,
        String name,
        LocalDateTime createTime
) {
}
