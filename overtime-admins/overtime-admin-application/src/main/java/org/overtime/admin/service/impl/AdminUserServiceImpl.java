package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.admin.domain.entity.AdminUser;
import org.overtime.admin.repository.AdminUserRepository;
import org.overtime.admin.service.AdminRoleService;
import org.overtime.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author ForteScarlet
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminUserServiceImpl extends StandardBaseService<AdminUser, Integer, AdminUserRepository> implements AdminUserService {
    private final AdminRoleService roleService;

    @Override
    protected @NotNull Class<AdminUser> entityType() {
        return AdminUser.class;
    }

    @Override
    public Mono<AdminUser> findByUsername(String username) {
        final var user = new AdminUser();
        user.setUsername(username);
        return getRepository().findOne(toExample(user));
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Mono<AdminUser> findUserFullInfoById(int userId) {
        return getRepository().findById(userId).flatMap(user ->
                roleService.findFullRolesByUserId(userId)
                        .collectList()
                        .map(roles -> {
                            user.setRoles(roles);
                            return user;
                        }));


    }

    @Transactional
    @Override
    public Mono<AdminUser> createUser(AdminUser user) {
        if (user.getStatus() == null) {
            user.setStatus(AdminUser.Status.NORMAL);
        }
        final var repository = getRepository();
        return repository.save(user)
                .flatMap(it -> {
                    final List<AdminRole> auths = it.getRoles();
                    if (auths != null && auths.size() > 0) {
                        // 重新设置权限
                        final var roleIds = Flux.fromIterable(auths).map(AdminRole::getId);
                        return roleService.setUserRoles(it.getId(), roleIds)
                                .collectList()
                                .map(list -> {
                                    it.setRoles(list);
                                    return it;
                                });
                    }

                    return Mono.just(it);
                });
    }

    @Override
    protected ExampleMatcher basicMatcher(ExampleMatcher matcher) {
        return super.basicMatcher(matcher);
    }
}

