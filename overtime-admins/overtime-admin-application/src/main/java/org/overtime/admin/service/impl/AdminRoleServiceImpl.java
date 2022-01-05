package org.overtime.admin.service.impl;

import org.overtime.admin.domain.entity.AdminRole;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.service.AdminRoleService;
import org.overtime.common.domain.PageableParameter;
import org.overtime.common.service.OvertimeR2dbcEntityTemplate;
import org.overtime.common.service.StandardR2dbcService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Service
public class AdminRoleServiceImpl extends StandardR2dbcService<AdminRole, Integer, AdminRoleRepository> implements AdminRoleService {
    private final OvertimeR2dbcEntityTemplate ovTemplate;

    public AdminRoleServiceImpl(AdminRoleRepository repository,
                                OvertimeR2dbcEntityTemplate ovTemplate) {
        super(repository);
        this.ovTemplate = ovTemplate;
    }

    @Override
    public Mono<AdminRole> findById(int id) {
        return getRepository().findById(id);
    }

    @Override
    public Flux<AdminRole> findRolesByUserId(int userId) {
        return getRepository().findAllByUserId(userId);
    }

    @Override
    public Mono<Long> count(AdminRole role) {
        final Example<AdminRole> example = toExample(role);
        return getRepository().count(example);
    }

    @Override
    public Flux<AdminRole> findList(AdminRole role, PageableParameter pageableParameter) {
        final Example<AdminRole> example = toExample(role);
        final Query query = ovTemplate.getMappedExample(example);
        return ovTemplate.getR2dbcEntityTemplate().select(query, AdminRole.class);
    }

    private Example<AdminRole> toExample(AdminRole role) {
        return Example.of(role,
                ExampleMatcher.matching()
                        .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()));
    }
}
