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
import org.overtime.common.Paged;
import org.overtime.common.service.StandardR2dbcService;
import org.overtime.common.service.utils.CriteriaUtil;
import org.overtime.common.service.utils.SqlIdentifierUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

/**
 * @author ForteScarlet
 */
@Service
public class AdminUserServiceImpl extends StandardR2dbcService<AdminUser, Integer, AdminUserRepository> implements AdminUserService {

    private final R2dbcEntityTemplate template;
    private final AdminRoleRepository roleRepository;
    private final AdminAuthRepository authRepository;
    private final AdminRouteRepository routeRepository;

    @Autowired
    public AdminUserServiceImpl(AdminUserRepository repository,
                                R2dbcEntityTemplate template,
                                AdminRoleRepository roleRepository,
                                AdminAuthRepository authRepository,
                                AdminRouteRepository routeRepository) {
        super(repository);
        this.template = template;
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

    /**
     * 根据参数查询用户列表
     * @param queryDTO params
     * @return Page AdminUser
     */
    @Override
    public Mono<Paged<AdminUserHidePassVO>> queryUserPaged(AdminUserListQueryDTO queryDTO) {
        var criteria = Criteria.empty();
        // username.
        criteria = CriteriaUtil.notNull(criteria, "username", queryDTO.getUsername(), (c, v) -> c.like("%" + v + "%"));
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "role_id", queryDTO.getRoles());
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "auth_id", queryDTO.getAuths());
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "route_id", queryDTO.getRoutes());

        final var query = Query.query(criteria).columns("id", "username", "create_time", "status");

        final var adminUserHidePassVO = queryUserPaged(query, queryDTO.getPageable());
        final var userPageInfo = getUserPageInfo(query, queryDTO.getPageable());

        return Paged.toPaged(adminUserHidePassVO, userPageInfo);
    }


    /**
     * 根据 query 查询数据。
     * @param query query
     * @return {@link AdminUserHidePassVO}
     */
    private Flux<AdminUserHidePassVO> queryUserPaged(Query query, Pageable pageable) {
        var columns = query.getColumns();

        // template : R2dbcEntityTemplate
        final var statementMapper = template.getDataAccessStrategy().getStatementMapper();
        var selectSpec = statementMapper.createSelect("admin_user_with_role_with_auth_with_route")
                // distinct!
                .distinct()
                .withPage(pageable)
                .doWithTable((table, spec) -> {
                    if (columns.isEmpty()) {
                        return spec.withProjection(table.asterisk());
                    } else {
                        return spec.withProjection(columns.stream().map(table::column).collect(Collectors.toList()));
                    }
                });

        final var criteria = query.getCriteria();
        if (criteria.isPresent()) {
            selectSpec = criteria.map(selectSpec::withCriteria).orElse(selectSpec);
        }

        final var operation = statementMapper.getMappedObject(selectSpec);
        final var rowMapper = template.getDataAccessStrategy().getRowMapper(AdminUserHidePassVO.class);

        return template.getDatabaseClient().sql(operation).map(rowMapper).all();
    }

    /**
     * 根据 query 获取分页信息。
     *
     * @param query query
     * @return {@link PageInfo}
     */
    private Mono<PageInfo> getUserPageInfo(Query query, Pageable pageable) {
        final var count = template.count(query, AdminUserHidePassVO.class);
        return count.map(total -> PageInfo.toPageInfo(total, pageable));
    }


}

