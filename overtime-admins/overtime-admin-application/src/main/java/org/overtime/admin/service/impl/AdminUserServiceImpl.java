package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminUser;
import org.overtime.admin.repository.AdminUserRepository;
import org.overtime.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminUserServiceImpl extends StandardBaseService<AdminUser, Integer, AdminUserRepository> implements AdminUserService {

    @Override
    protected @NotNull Class<AdminUser> entityType() {
        return AdminUser.class;
    }

    @Override
    public Mono<AdminUser> findByUsername(String username) {
        final AdminUser user = new AdminUser();
        user.setUsername(username);
        return getRepository().findOne(toExample(user));
    }

    @Override
    protected ExampleMatcher basicMatcher(ExampleMatcher matcher) {
        return super.basicMatcher(matcher);
    }
}

