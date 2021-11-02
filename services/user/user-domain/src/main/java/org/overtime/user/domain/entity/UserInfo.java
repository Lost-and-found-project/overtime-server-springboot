package org.overtime.user.domain.entity;

import lombok.Data;
import org.overtime.common.domain.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 用户信息实体。
 *
 * @author ForteScarlet
 * @see User
 * @see UserWithInfo
 */
@Data
@Table("ov_user_info")
public class UserInfo implements Entity {
    @Id
    private Long id;

    private Long userId;

    /** Email. */
    private String email;

    /** Phone */
    private String phone;

    /** Create time. */
    private LocalDateTime createTime;

}
