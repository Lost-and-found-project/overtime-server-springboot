package org.overtime.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.service.AdminRoleService;
import org.overtime.common.service.OvertimeR2dbcEntityTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author ForteScarlet
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminRoleServiceImpl extends StandardBaseService<AdminRole, Integer, AdminRoleRepository> implements AdminRoleService {

    @Override
    public Flux<AdminRole> findRolesByUserId(int userId) {
        return getRepository().findAllByUserId(userId);
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
