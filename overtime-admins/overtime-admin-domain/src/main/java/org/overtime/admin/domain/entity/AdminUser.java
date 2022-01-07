package org.overtime.admin.domain.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.overtime.common.auth.UserInfo;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理账号。
 *
 * @author ForteScarlet
 */
@Table("admin_user")
@Data
@ApiModel("管理员用户")
public final class AdminUser implements UserInfo {
    @Id
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    @CreatedDate
    private LocalDateTime createTime;
    /**
     * 0: 正常
     */
    private Short status;

    /**
     * 用户的所属角色列表。
     */
    @Transient
    private List<AdminRole> roles;

    @Override
    public boolean enabled() {
        if (status == null) return false;
        return status.equals(Status.NORMAL);
    }

    public static final class Status {
        /**
         * 正常状态。
         */
        public static final short NORMAL = 0;

        /**
         * 被封禁/被禁用。
         */
        public static final short BANNED = -1;
    }
}
