package org.overtime.admin.service;

import org.overtime.admin.domain.entity.AdminUser;
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

    /**
     * 根据ID查询完整信息。
     * @param userId user Id
     * @return user.
     */
    Mono<AdminUser> findUserFullInfoById(int userId);

    /**
     * 新增/修改一个用户。
     * @param user user
     * @return user
     */
    Mono<AdminUser> modifyUser(AdminUser user);
}