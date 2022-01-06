package org.overtime.admin.service;

import org.overtime.admin.domain.entity.AdminUser;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 管理用户服务接口。
 *
 * @author ForteScarlet
 */
public interface AdminUserService extends BaseService<AdminUser> {

    /**
     * 根据用户名查询
     *
     * @param username username
     * @return user
     */
    Mono<AdminUser> findByUsername(String username);

}
