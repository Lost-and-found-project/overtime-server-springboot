package org.overtime.admin.bean.vo;

import org.overtime.admin.bean.dto.AdminUserListQueryDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理用户基本信息。
 * @see org.overtime.admin.service.AdminUserService#queryUserPaged(AdminUserListQueryDTO)
 * @author ForteScarlet
 */
@Table("admin_user_with_role_with_auth_with_route")
public record AdminUserHidePassVO(
        @Id Integer id, String username, LocalDateTime createTime, Short status
) {
}
