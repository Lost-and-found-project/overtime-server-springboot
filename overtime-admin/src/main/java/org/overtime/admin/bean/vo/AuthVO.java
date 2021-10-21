package org.overtime.admin.bean.vo;

import org.overtime.admin.bean.domain.AdminAuth;

/**
 * @author ForteScarlet
 */
@Deprecated // see https://docs.spring.io/spring-data/r2dbc/docs/1.3.5/reference/html/#r2dbc.repositories.queries
public record AuthVO(Integer id, String name) {

    public static AuthVO byAuth(AdminAuth auth) {
        return new AuthVO(auth.id(), auth.name());
    }
}
