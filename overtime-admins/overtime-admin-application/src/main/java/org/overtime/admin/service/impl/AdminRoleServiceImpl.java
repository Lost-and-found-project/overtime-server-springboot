package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminAuth;
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
        final var repository = getRepository();
        return repository.findAllByUserId(userId).flatMap(role -> {
            // find auth
            return authService.findAuthsFullByRoleId(role.getId()).collectList().map(auths -> {
                role.setAuths(auths);
                return role;
            });
        });
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    @Override
    public Flux<AdminRole> setUserRoles(int userId, Publisher<Integer> roles) {
        final var repository = getRepository();
        // 删除所有用户角色，重新赋值.
        return repository.deleteByUserId(userId).flatMapMany(deleted -> {
            final var roleIds = Flux.from(roles)
                    .flatMap(authId -> repository.setUserRole(userId, authId).map(v -> authId));

            // 再次查询所有的角色
            return repository.findAllById(roleIds);
        });
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    @Override
    public Mono<AdminRole> modifyRole(AdminRole role) {
        final var repository = getRepository();
        return repository.save(role).flatMap(saved -> {
            final var auths = role.getAuths();
            if (auths != null && auths.size() > 0) {
                final var authIds = Flux.fromIterable(auths).map(AdminAuth::getId);
                final var newAuths = authService.setRoleAuths(saved.getId(), authIds);
                return newAuths.collectList().map(list -> {
                    saved.setAuths(list);
                    return saved;
                });
            }

            return Mono.just(saved);
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
