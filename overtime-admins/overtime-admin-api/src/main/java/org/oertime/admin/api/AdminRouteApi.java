package org.oertime.admin.api;

import org.overtime.admin.domain.entity.AdminRoute;
import org.overtime.common.ServiceConstant;
import org.overtime.common.domain.PageableParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理路由相关api.
 *
 * @author ForteScarlet
 */
@ReactiveFeignClient(value = ServiceConstant.ADMIN_SERVICE, path = AdminRouteApi.API_REQ_MAPPING)
public interface AdminRouteApi {
    String API_REQ_MAPPING = "/admin/route";


    String FIND_BY_ID = "/id/{id}";

    /**
     * 根据ID查询
     *
     * @param id id
     * @return id
     */
    @GetMapping(FIND_BY_ID)
    Mono<AdminRoute> findById(@PathVariable("id") int id);

    String FIND_BY_PARENT_ID = "/parent/id/{id}";

    /**
     * 根据PID查询
     *
     * @param parentId parent id
     * @return id
     */
    @GetMapping(FIND_BY_PARENT_ID)
    Flux<AdminRoute> findByParentId(@PathVariable("id") int parentId);


    String FIND_AUTHS_BY_ROLE_ID = "/role/{id}/auths";

    /**
     * 根据角色ID查询其列表。
     *
     * @param id 用户id
     * @return roles
     */
    @GetMapping(FIND_AUTHS_BY_ROLE_ID)
    Flux<AdminRoute> findRoutesByAuthId(@PathVariable int id);


    String COUNT = "/count";

    /**
     * 条件查询数据数量。
     *
     * @param route 条件
     * @return count
     */
    @GetMapping(COUNT)
    Mono<Long> count(AdminRoute route);


    String FIND_LIST = "/list";

    /**
     * 条件查询所有列表。
     *
     * @param route 条件
     * @return list
     */
    @GetMapping(FIND_LIST)
    Flux<AdminRoute> findList(AdminRoute route, PageableParameter pageableParameter);


}
