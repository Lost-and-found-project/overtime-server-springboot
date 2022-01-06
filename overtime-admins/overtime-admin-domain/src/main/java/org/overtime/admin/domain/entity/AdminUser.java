package org.overtime.admin.domain.entity;

import lombok.Data;
import org.overtime.common.auth.UserInfo;
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
public final class AdminUser implements UserInfo {
    @Id
    private Integer id;
    private String username;
    private String password;
    private LocalDateTime createTime;
    /**
     * 0: 正常
     */
    private Short status;

    @Override
    public boolean enabled() {
        return status == 0;
    }
}
