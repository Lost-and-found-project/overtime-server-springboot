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
public interface AdminRoleService {

    /**
     * 根据ID查询role
     *
     * @param id id
     * @return id
     */
    Mono<AdminRole> findById(@PathVariable("id") int id);

    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * @param userId 用户id
     * @return roles
     */
    Flux<AdminRole> findRolesByUserId(@PathVariable int userId);


    /**
     * 条件查询数据数量。
     *
     * @param role 条件
     * @return count
     */
    Mono<Long> count(AdminRole role);


    /**
     * 条件查询所有角色列表。
     *
     * @param role 角色
     * @return list
     */
    Flux<AdminRole> findList(AdminRole role, PageableParameter pageableParameter);

}
