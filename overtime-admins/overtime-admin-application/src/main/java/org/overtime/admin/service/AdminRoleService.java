package org.overtime.admin.service;

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
public interface AdminRoleService extends BaseService<AdminRole> {

    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * @param userId 用户id
     * @return roles
     */
    Flux<AdminRole> findRolesByUserId(int userId);

}
