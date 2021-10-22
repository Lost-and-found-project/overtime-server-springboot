package org.overtime.admin.bean.domain;

import java.io.Serial;
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
 * @param roleName        角色名称，不可重复
 * @param roleCreateTime  创建日期
 * @param authId          权限ID
 * @param authKey         权限key，应该为全英文，不可重复
 * @param authName        权限描述名称
 * @param authCreateTime  创建时间
 *
 * @author forte
 */
@Table("admin_user_with_role_with_auth")
public record AdminUserWithRoleWithAuth(Integer id, String username, String password,
                                        Date createTime, Short status, Integer roleId,
                                        String roleName, Date roleCreateTime,
                                        Integer authId, String authKey, String authName,
                                        Date authCreateTime) implements View {
    @Serial
    private static final long serialVersionUID = 1L;
}

