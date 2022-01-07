package org.overtime.admin.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.oertime.admin.api.AdminRouteApi;
import org.overtime.admin.domain.entity.AdminRoute;
import org.overtime.admin.service.AdminRouteService;
import org.overtime.common.domain.PageableParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 权限路由相关控制器
 *
 * @author ForteScarlet
 */
@RestController
@RequestMapping(AdminRouteApi.API_REQ_MAPPING)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminRouteController implements AdminRouteApi {

    private final AdminRouteService routeService;


    /**
     * 根据ID查询role
     *
     * @param id id
     * @return id
     */
    @GetMapping(FIND_BY_ID)
    @Override
    public Mono<AdminRoute> findById(@PathVariable int id) {
        return routeService.findById(id);
    }


    /**
     * 根据PID查询
     *
     * @param id parent id
     * @return id
     */
    @GetMapping(FIND_BY_PARENT_ID)
    @Override
    public Flux<AdminRoute> findByParentId(@PathVariable int id) {
        return routeService.findByParentId(id);
    }

    /**
     * 根据角色ID查询其对应的权限列表。
     *
     * @param id 用户id
     * @return roles
     */
    @GetMapping(FIND_AUTHS_BY_ROLE_ID)
    @Override
    public Flux<AdminRoute> findRoutesByAuthId(@PathVariable int id) {
        return routeService.findRoutesByAuthId(id);
    }

    /**
     * 条件查询数据数量。
     *
     * @param route 条件
     * @return count
     */
    @GetMapping(COUNT)
    @Override
    public Mono<Long> count(AdminRoute route) {
        return routeService.count(route);
    }


    /**
     * 条件查询所有权限列表。
     *
     * @param route 条件
     * @return list
     */
    @GetMapping(FIND_LIST)
    @Override
    public Flux<AdminRoute> findList(AdminRoute route, PageableParameter pageableParameter) {
        return routeService.findList(route, pageableParameter);
    }

    /**
     * 从根目录开始查询所有的route。
     *
     * @param full 是否填充children。
     * @return routes
     */
    @GetMapping("/all")
    public Flux<AdminRoute> all(boolean full) {
        return routeService.all(full);
    }

    /**
     * 新增/修改路由信息
     *
     * @param adminRoute route info
     * @return route
     */
    @ApiOperation(
            value = "新增/修改路由信息",
            notes = "如果有ID则为修改，否则为新增。"
    )
    @PostMapping
    public Mono<AdminRoute> modifyRoute(@RequestBody AdminRoute adminRoute) {
        return routeService.modifyRoute(adminRoute);
    }
}
