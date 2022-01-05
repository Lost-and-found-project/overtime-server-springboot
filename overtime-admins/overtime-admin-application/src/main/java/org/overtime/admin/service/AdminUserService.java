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
public interface AdminUserService {


    /**
     * 根据id查询
     * @param id id
     * @return user
     */
    Mono<AdminUser> findById(int id);


    /**
     * 根据用户名查询
     * @param username username
     * @return user
     */
    Mono<AdminUser> findByUsername(String username);

    /**
     * 查询获取当前管理员用户数量。
     *
     * @return total
     */
    Mono<Long> getCount(AdminUser adminUser);

    /**
     * 根据参数查询用户列表
     *
     * @return Page AdminUser
     */
    Flux<AdminUser> queryUsers(AdminUser adminUser, Pageable pageable);


}
