package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.admin.bean.domain.AdminRoute;
import org.overtime.admin.service.AdminRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
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

}
