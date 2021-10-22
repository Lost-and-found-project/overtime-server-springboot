package org.overtime.admin.service.impl;

import org.overtime.admin.bean.domain.AdminUser;
import org.overtime.admin.bean.dto.AdminUserListQueryDTO;
import org.overtime.admin.bean.vo.*;
import org.overtime.admin.repository.AdminAuthRepository;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.repository.AdminRouteRepository;
import org.overtime.admin.repository.AdminUserRepository;
import org.overtime.admin.service.AdminUserService;
import org.overtime.common.PageInfo;
import org.overtime.common.service.StandardR2dbcService;
import org.overtime.common.service.utils.CriteriaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Service
public class AdminUserServiceImpl extends StandardR2dbcService<AdminUser, Integer, AdminUserRepository> implements AdminUserService {

    private final R2dbcEntityTemplate template;
    private final DatabaseClient databaseClient;
    private final AdminRoleRepository roleRepository;
    private final AdminAuthRepository authRepository;
    private final AdminRouteRepository routeRepository;

    @Autowired
    public AdminUserServiceImpl(AdminUserRepository repository,
                                R2dbcEntityTemplate template,
                                DatabaseClient databaseClient,
                                AdminRoleRepository roleRepository,
                                AdminAuthRepository authRepository,
                                AdminRouteRepository routeRepository) {
        super(repository);
        this.template = template;
        this.databaseClient = databaseClient;
        this.roleRepository = roleRepository;
        this.authRepository = authRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Mono<AdminUserListQueryParamVO> getUserListQueryParam() {
        final var roles = roleRepository.findAll(RoleVO.class).collectList();
        final var auths = authRepository.findAll(AuthVO.class).collectList();
        final var routes = routeRepository.findAll(RouteVO.class).collectList();


        return Mono.zip(roles, auths, routes).map((tuple) -> new AdminUserListQueryParamVO(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }

    @Override
    public Flux<AdminUserHidePassVO> queryUserPaged(AdminUserListQueryDTO queryDTO) {
        Criteria criteria = Criteria.empty();
        // username.
        criteria = CriteriaUtil.notNull(criteria, "username", queryDTO.getUsername(), (c, v) -> c.like("%" + v + "%"));
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "role_id", queryDTO.getRoles());
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "auth_id", queryDTO.getAuths());
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "route_id", queryDTO.getRoutes());

        final Query query = Query.query(criteria).with(queryDTO.getPageable());

        System.out.println("criteria = " + criteria);
        System.out.println("query = " + query);

        // SqlIdentifier.quoted()

        return template.select(query, AdminUserHidePassVO.class);
    }


    @Override
    public Mono<PageInfo> getUserPageInfo(AdminUserListQueryDTO queryDTO) {
        return null;
    }
}