package org.overtime.admin.service;

import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.common.domain.PageableParameter;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理角色服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminAuthService extends BaseService<AdminAuth> {

    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * @param roleId 角色id
     * @return roles
     */
    Flux<AdminAuth> findAuthsByRoleId(int roleId);

}
