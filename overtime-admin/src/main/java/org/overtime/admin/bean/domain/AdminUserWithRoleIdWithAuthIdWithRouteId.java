package org.overtime.admin.bean.domain;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Value;
import org.overtime.common.domain.View;
import org.springframework.data.relational.core.mapping.Table;


/**
 * @param id              ID
 * @param username        用户名
 * @param password        密码
 * @param createTime      用户创建时间
 * @param status          用户状态
 * @param roleId          角色ID
 * @param authId          权限ID
 * @param routeId         路由的路径。不可重复
 *
 * @author forte
 */
@Table("admin_user_with_role_id_with_auth_id_with_route_id")
public record AdminUserWithRoleIdWithAuthIdWithRouteId(Integer id, String username,
                                                       String password, LocalDateTime createTime,
                                                       Short status, Integer roleId,
                                                       Integer authId,
                                                       Integer routeId) implements View {
    @Serial
    private static final long serialVersionUID = 1L;
}

