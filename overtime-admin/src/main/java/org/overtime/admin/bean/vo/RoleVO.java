package org.overtime.admin.bean.vo;

import org.overtime.admin.bean.domain.AdminRole;

/**
 * @author ForteScarlet
 */
public record RoleVO(Integer id, String name) {


    public static RoleVO byRole(AdminRole role) {
        return new RoleVO(role.id(), role.name());
    }
}
