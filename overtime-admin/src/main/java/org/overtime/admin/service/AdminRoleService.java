package org.overtime.admin.service;

import org.overtime.admin.domain.AdminRole;
import reactor.core.publisher.Mono;

/**
 * 管理角色服务接口。
 * @author ForteScarlet
 */
public interface AdminRoleService {

    /**
     * 根据ID查询role。
     * @param id ID
     * @return AdminRole
     */
    Mono<AdminRole> findById(Integer id);

}
