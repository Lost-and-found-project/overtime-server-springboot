package org.overtime.admin.service.impl;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
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
import org.overtime.common.service.OvertimeR2dbcEntityTemplate;
import org.overtime.common.service.StandardR2dbcService;
import org.overtime.common.service.utils.CriteriaUtil;
import org.overtime.common.service.utils.DistinctFunctions;
import org.overtime.configuration.r2dbc.OvertimeR2dbcEntityTemplateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.core.StatementMapper;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

/**
 * @author ForteScarlet
 */
@Service
public class AdminUserServiceImpl extends StandardR2dbcService<AdminUser, Integer, AdminUserRepository> implements AdminUserService {

    private final R2dbcEntityTemplate template;
    private final OvertimeR2dbcEntityTemplate ovTemplate;
    private final AdminRoleRepository roleRepository;
    private final AdminAuthRepository authRepository;
    private final AdminRouteRepository routeRepository;

    private final BiFunction<Row, RowMetadata, AdminUserHidePassVO> adminUserHidePassVoRowMapper;


    @Autowired
    public AdminUserServiceImpl(AdminUserRepository repository,
                                R2dbcEntityTemplate template,
                                OvertimeR2dbcEntityTemplate ovTemplate,
                                AdminRoleRepository roleRepository,
                                AdminAuthRepository authRepository,
                                AdminRouteRepository routeRepository) {
        super(repository);
        this.template = template;
        this.ovTemplate = ovTemplate;
        this.roleRepository = roleRepository;
        this.authRepository = authRepository;
        this.routeRepository = routeRepository;

        // init row mapper
        this.adminUserHidePassVoRowMapper = template.getDataAccessStrategy().getRowMapper(AdminUserHidePassVO.class);

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
        // final var query = Query.query(criteria).columns("id", "username", "create_time", "status");
        // var columns = query.getColumns();

        return ovTemplate.selectPaged(AdminUserHidePassVO.class, AdminUserHidePassVO.class, Query.query(criteria)
                .columns("id", "username", "create_time", "status")
                .with(queryDTO.getPageable()), true);

        // final var statementMapper = template.getDataAccessStrategy().getStatementMapper();
        // final var selectSpec = statementMapper.createSelect("admin_user_with_role_with_auth_with_route")
        //         .withPage(queryDTO.getPageable())
        //         .withCriteria(criteria);
        //
        //
        // final var adminUserHidePassVO = queryUserPaged(statementMapper, selectSpec);
        // final var userPageInfo = getUserPageInfo(statementMapper, selectSpec, queryDTO.getPageable());
        //
        // return Paged.toPaged(adminUserHidePassVO, userPageInfo);
    }


    /**
     * 根据 query 查询数据。
     * @return {@link AdminUserHidePassVO}
     */
    private Flux<AdminUserHidePassVO> queryUserPaged(StatementMapper statementMapper, StatementMapper.SelectSpec selectSpec) {
        selectSpec = selectSpec
                .distinct()
                .doWithTable((table, spec) -> spec.withProjection(table.column("id"), table.column("username"), table.column("create_time"), table.column("status")));
        final var operation = statementMapper.getMappedObject(selectSpec);

        return template.getDatabaseClient().sql(operation).map(adminUserHidePassVoRowMapper).all();
    }

    /**
     * 根据 query 获取分页信息。
     *
     * @return {@link PageInfo}
     */
    private Mono<PageInfo> getUserPageInfo(StatementMapper statementMapper, StatementMapper.SelectSpec selectSpec, Pageable pageable) {
        selectSpec = selectSpec.doWithTable((table, spec) -> spec.withProjection(DistinctFunctions.count(table.column("id"))));
        final var operation = statementMapper.getMappedObject(selectSpec);


        return template.getDatabaseClient().sql(operation).map(r -> r.get(0, Long.class)).first().map(total -> PageInfo.toPageInfo(total, pageable));
    }


}

