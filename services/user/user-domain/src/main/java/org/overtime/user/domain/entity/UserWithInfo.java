package org.overtime.user.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 携带用户信息的 {@link User} 实体。
 *
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table("ov_user")
public class UserWithInfo extends User {

    /**
     * 用户信息。
     */
    private UserInfo userInfo;

}
