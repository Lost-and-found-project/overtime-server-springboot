package org.overtime.admin.service.impl;

import org.overtime.admin.domain.entity.AdminUser;
import org.overtime.admin.domain.param.AdminUserRoleEditParam;
import org.overtime.admin.domain.vo.AdminUserListQueryParamVO;
import org.overtime.admin.domain.vo.AuthVO;
import org.overtime.admin.domain.vo.RoleVO;
import org.overtime.admin.domain.vo.RouteVO;
import org.overtime.admin.repository.AdminAuthRepository;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.repository.AdminRouteRepository;
import org.overtime.admin.repository.AdminUserRepository;
import org.overtime.admin.service.AdminUserService;
import org.overtime.common.service.OvertimeR2dbcEntityTemplate;
import org.overtime.common.service.StandardR2dbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Service
public class AdminUserServiceImpl extends StandardR2dbcService<AdminUser, Integer, AdminUserRepository> implements AdminUserService {

    private final OvertimeR2dbcEntityTemplate ovTemplate;
    private final AdminRoleRepository roleRepository;
    private final AdminAuthRepository authRepository;
    private final AdminRouteRepository routeRepository;

    @Autowired
    public AdminUserServiceImpl(AdminUserRepository repository, OvertimeR2dbcEntityTemplate ovTemplate, AdminRoleRepository roleRepository, AdminAuthRepository authRepository, AdminRouteRepository routeRepository) {
        super(repository);
        this.ovTemplate = ovTemplate;
        this.roleRepository = roleRepository;
        this.authRepository = authRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Mono<AdminUser> findById(int id) {
        final AdminUser user = new AdminUser();
        user.setId(id);
        return getRepository().findOne(Example.of(user));
    }

    @Override
    public Mono<AdminUser> findByUsername(String username) {
        final AdminUser user = new AdminUser();
        user.setUsername(username);
        return getRepository().findOne(Example.of(user));
    }

    @Override
    public Mono<Long> getCount(AdminUser adminUser) {
        return getRepository().count(toExample(adminUser));
    }


    @Override
    public Flux<AdminUser> queryUsers(AdminUser adminUser, Pageable pageable) {
        final var template = ovTemplate.getR2dbcEntityTemplate();
        final var example = toExample(adminUser);
        var query = ovTemplate.getMappedExample(example);
        if (pageable != null) {
            query = query.with(pageable);
        }

        return template.select(query, AdminUser.class)
                .map(user -> {
                    user.setPassword(null); // hide password
                    return user;
                });
    }


    private Example<AdminUser> toExample(AdminUser adminUser) {
        final var matcher = ExampleMatcher.matching().withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains());
        return Example.of(adminUser, matcher);

    }

    private Mono<AdminUserListQueryParamVO> getUserListQueryParam() {
        final var roles = roleRepository.findAllForQueryParam(RoleVO.class).collectList();
        final var auths = authRepository.findAllForQueryParam(AuthVO.class).collectList();
        final var routes = routeRepository.findAllForQueryParam(RouteVO.class).collectList();


        return Mono.zip(roles, auths, routes).map((tuple) -> new AdminUserListQueryParamVO(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }

    // /**
    //  * 根据参数查询用户列表
    //  *
    //  * @param queryDTO params
    //  * @return Page AdminUser
    //  */
    // private Mono<Paged<AdminUserHidePassVO>> queryUserPaged(AdminUserListQueryRequestParameter queryDTO) {
    //     var criteria = Criteria.empty();
    //     // username.
    //     criteria = CriteriaUtil.notNull(criteria, "username", queryDTO.getUsername(), (c, v) -> c.like("%" + v + "%"));
    //     criteria = CriteriaUtil.andInIfNotEmpty(criteria, "role_id", queryDTO.getRoles());
    //     criteria = CriteriaUtil.andInIfNotEmpty(criteria, "auth_id", queryDTO.getAuths());
    //     criteria = CriteriaUtil.andInIfNotEmpty(criteria, "route_id", queryDTO.getRoutes());
    //
    //     return ovTemplate.selectPaged(AdminUserHidePassVO.class, AdminUserHidePassVO.class, Query.query(criteria)
    //             .columns("id", "username", "create_time", "status")
    //             .with(queryDTO.getPageable()), true);
    // }

    /**
     * 增加用户的角色，返回增加后的角色ID列表。
     *
     * @param param param
     * @return ids
     */
    //@Transactional(rollbackFor = Exception.class)
    private Flux<Integer> addRole(AdminUserRoleEditParam param) {
        if (param.getRoles().isEmpty()) {
            return getUserRoleIds(param.getUserId());
        }

        final Integer userId = param.getUserId();
        final var insert = ovTemplate.getR2dbcEntityTemplate().insert(AdminUserRoleEditParam.Entity.class).into(AdminUserRoleEditParam.Entity.TABLE);

        return param.toEntryFlux().flatMap(insert::using).concatMap(v -> getUserRoleIds(userId));
    }


    /**
     * 移除管理用户的角色，返回移除后的角色ID列表。
     *
     * @param param param
     * @return ids
     */
    // @Transactional(rollbackFor = Exception.class)
    private Flux<Integer> removeRole(AdminUserRoleEditParam param) {
        final Integer userId = param.getUserId();
        if (param.getRoles().isEmpty()) {
            return getUserRoleIds(userId);
        }

        final Criteria userIdCriteria = Criteria.where("user_id").is(userId);
        final Criteria rolesCriteria = Criteria.where("roles").in(param.getRoles());
        Query query = Query.query(userIdCriteria.and(rolesCriteria));

        return ovTemplate.getR2dbcEntityTemplate().delete(AdminUserRoleEditParam.Entity.class).from(AdminUserRoleEditParam.Entity.TABLE).matching(query).all().flatMapMany(rows -> getUserRoleIds(userId));
    }


    /**
     * 查询管理账户下所有对应的角色列表。
     *
     * @param userId userId
     * @return roles
     */
    private Flux<Integer> getUserRoleIds(int userId) {
        return getRepository().getUserRolesId(userId);
    }
}

