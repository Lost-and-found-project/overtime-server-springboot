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
 *
 * @author forte
 */
@Table("admin_user_with_role")
public record AdminUserWithRole(Integer id, String username, String password,
                                Date createTime, Short status, Integer roleId,
                                String roleName, Date roleCreateTime) implements View {
    @Serial
    private static final long serialVersionUID = 1L;
}

