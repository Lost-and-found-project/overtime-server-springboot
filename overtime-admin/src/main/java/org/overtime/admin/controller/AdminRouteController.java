package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.admin.bean.domain.AdminRoute;
import org.overtime.admin.service.AdminRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

/**
 * @author ForteScarlet
 */
@Slf4j
@RestController
@RequestMapping("/admin/route")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminRouteController {

    private final AdminRouteService adminRouteService;

    /**
     * 通过ID查询 full route
     *
     * @param id route id
     * @return admin route
     */
    @GetMapping("/full/{id}")
    public Mono<AdminRoute> getFullAdminRoute(@PathVariable Integer id) {
        return adminRouteService.findById(id, true);
    }

    /**
     * 通过parent id查询所有的 full route
     *
     * @param pid 父ID
     * @return admin routes
     */
    @GetMapping({
            "/full/parent/{pid}",
            "/full/root"
    })
    public Flux<AdminRoute> getFullAdminRouteByParentId(@PathVariable(required = false) Integer pid) {
        return adminRouteService.findByParentId(pid, true);
    }

    /**
     * 通过ID查询 barren route
     *
     * @param id route id
     * @return admin route
     */
    @GetMapping("/barren/{id}")
    public Mono<AdminRoute> getBarrenAdminRoute(@PathVariable Integer id) {
        return adminRouteService.findById(id, false);
    }


    /**
     * 通过parent id查询 barren route
     *
     * @param pid parent id
     * @return admin routes
     */
    @GetMapping({
            "/barren/parent/{pid}",
            "/barren/root"
    })
    public Flux<AdminRoute> getBarrenAdminRouteByParentId(@PathVariable(required = false) Integer pid) {
        return adminRouteService.findByParentId(pid, false);
    }


    /**
     * 创建一个路由信息
     *
     * @param route 路由
     * @return route
     */
    @PostMapping("/create")
    public Mono<AdminRoute> createAdminRoute(@NotNull @RequestBody AdminRoute route) {
        return adminRouteService.createRoutes(Collections.singletonList(route)).last();
    }


    /**
     * 修改一个路由信息。
     *
     * @param routes routes.
     * @return updated routes.
     */
    @PostMapping("/update")
    public Flux<AdminRoute> updateAdminRoute(@Nullable @RequestBody List<AdminRoute> routes) {
        if (routes == null) {
            routes = Collections.emptyList();
        }

        return adminRouteService.updateRoutes(routes);
    }


    /**
     * 删除一个管理路由。
     */
    @PostMapping("/delete/{id}")
    public Mono<Void> deleteAdminRoute(@PathVariable Integer id) {
        return adminRouteService.deleteRoutes(id);
    }


}
