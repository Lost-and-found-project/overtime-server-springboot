package org.overtime.admin.domain.vo;

import org.overtime.admin.domain.param.AdminUserListQueryRequestParameter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理用户基本信息。
 *
 * @author ForteScarlet
 * @see org.overtime.admin.service.AdminUserService#queryUserPaged(AdminUserListQueryRequestParameter)
 */
@Table("admin_user_with_role_with_auth_with_route")
public record AdminUserHidePassVO(
        @Id Integer id, String username, LocalDateTime createTime, Short status
) {
}
