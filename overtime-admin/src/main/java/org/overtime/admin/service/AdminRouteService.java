package org.overtime.admin.service;

import org.jetbrains.annotations.Nullable;
import org.overtime.admin.bean.domain.AdminRoute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 路由服务接口。
 * @author ForteScarlet
 */
public interface AdminRouteService {


    /**
     * 根据ID查询AdminRoute。
     * @param id id。不应为null。
     * @param full 是否是完整信息，即填充children。
     * @throws IllegalArgumentException id was null
     * @return admin route
     */
    Mono<AdminRoute> findById(Integer id, boolean full);


    /**
     * 根据 parent ID查询AdminRoute
     * @param parentId parentId。可以为null，为null即查询root route。
     * @param full 是否填充children。
     * @return admin route
     */
    Flux<AdminRoute> findByParentId(@Nullable Integer parentId, boolean full);

}
