package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.service.AdminAuthService;
import org.overtime.admin.service.AdminRoleService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminRoleServiceImpl extends StandardBaseService<AdminRole, Integer, AdminRoleRepository> implements AdminRoleService {
    private final AdminAuthService authService;

    @Override
    public Flux<AdminRole> findRolesByUserId(int userId) {
        return getRepository().findAllByUserId(userId);
    }

    @Override
    public Flux<AdminRole> findFullRolesByUserId(int userId) {
        final AdminRoleRepository repository = getRepository();
        return repository.findAllByUserId(userId).flatMap(role -> {
            // find auth
            return authService.findAuthsFullByRoleId(role.getId()).collectList().map(auths -> {
                role.setAuths(auths);
                return role;
            });
        });
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Flux<AdminRole> setUserRoles(int userId, Publisher<Integer> roles) {
        final AdminRoleRepository repository = getRepository();
        // 删除所有用户角色，重新赋值.
        return repository.deleteByUserId(userId).flatMapMany(deleted -> {
            final var roleIds = Flux.from(roles).map(authId -> {
                repository.setUserRole(userId, authId);
                return authId;
            });

            // 再次查询所有的角色
            return repository.findAllById(roleIds);
        });
    }

    @Override
    protected @NotNull Class<AdminRole> entityType() {
        return AdminRole.class;
    }

    @Override
    protected ExampleMatcher basicMatcher(ExampleMatcher matcher) {
        return matcher.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
