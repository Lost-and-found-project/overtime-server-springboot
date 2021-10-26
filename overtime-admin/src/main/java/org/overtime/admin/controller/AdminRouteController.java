package org.overtime.admin.controller;

import io.netty.buffer.ByteBuf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.bean.domain.AdminRoute;
import org.overtime.admin.service.AdminRouteService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

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
        return adminRouteService.createRoutes(route).last();
    }

    /**
     * 删除一个管理路由。
     */
    @PostMapping("/delete/{id}")
    public Mono<Void> deleteAdminRoute(@PathVariable Integer id) {
        return adminRouteService.deleteRoutes(id);
    }


    @GetMapping("/test")
    public Flux<String> test() {
        return Flux.push(sink -> {
            sink.onRequest(req -> {
                System.out.println("REQ: " + req);
                sink.next("REQ: " + req);
            });
        });
    }


}
