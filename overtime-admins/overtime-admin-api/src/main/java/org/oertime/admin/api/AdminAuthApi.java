package org.oertime.admin.api;

import org.overtime.admin.domain.entity.AdminAuth;
import org.overtime.common.ServiceConstant;
import org.overtime.common.domain.PageableParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理员权限相关api.
 *
 * @author ForteScarlet
 */
@ReactiveFeignClient(value = ServiceConstant.ADMIN_SERVICE, path = AdminAuthApi.API_REQ_MAPPING)
public interface AdminAuthApi {
    String API_REQ_MAPPING = "/admin/auth";


    String FIND_BY_ID = "/id/{id}";

    /**
     * 根据ID查询role
     *
     * @param id id
     * @return id
     */
    @GetMapping(FIND_BY_ID)
    Mono<AdminAuth> findById(@PathVariable("id") int id);


    String FIND_AUTHS_BY_ROLE_ID = "/role/{id}/auths";

    /**
     * 根据角色ID查询其对应的权限列表。
     *
     * @param id 用户id
     * @return roles
     */
    @GetMapping(FIND_AUTHS_BY_ROLE_ID)
    Flux<AdminAuth> findAuthByRoleId(@PathVariable int id);


    String COUNT = "/count";

    /**
     * 条件查询数据数量。
     *
     * @param auth 条件
     * @return count
     */
    @GetMapping(COUNT)
    Mono<Long> count(AdminAuth auth);


    String FIND_LIST = "/list";

    /**
     * 条件查询所有权限列表。
     *
     * @param auth 条件
     * @return list
     */
    @GetMapping(FIND_LIST)
    Flux<AdminAuth> findList(AdminAuth auth, PageableParameter pageableParameter);


}
