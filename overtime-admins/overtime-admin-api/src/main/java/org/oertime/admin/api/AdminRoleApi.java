package org.oertime.admin.api;

import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.common.ServiceConstant;
import org.overtime.common.domain.PageableParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理员角色相关api.
 *
 * @author ForteScarlet
 */
@ReactiveFeignClient(value = ServiceConstant.ADMIN_SERVICE, path = AdminRoleApi.API_REQ_MAPPING)
public interface AdminRoleApi {
    String API_REQ_MAPPING = "/admin/role";


    String FIND_BY_ID = "/id/{id}";

    /**
     * 根据ID查询role
     *
     * @param id id
     * @return id
     */
    @GetMapping(FIND_BY_ID)
    Mono<AdminRole> findById(@PathVariable("id") int id);


    String FIND_ROLES_BY_USER_ID = "/user/{id}/roles";

    /**
     * 根据用户ID查询其对应的角色列表。
     *
     * @param id 用户id
     * @return roles
     */
    @GetMapping(FIND_ROLES_BY_USER_ID)
    Flux<AdminRole> findRolesByUserId(@PathVariable int id);


    String COUNT = "/count";

    /**
     * 条件查询数据数量。
     *
     * @param role 条件
     * @return count
     */
    @GetMapping(COUNT)
    Mono<Long> count(AdminRole role);


    String FIND_LIST = "/list";

    /**
     * 条件查询所有角色列表。
     *
     * @param role 角色
     * @return list
     */
    @GetMapping(FIND_LIST)
    Flux<AdminRole> findList(AdminRole role, PageableParameter pageableParameter);


}
