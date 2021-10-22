package org.overtime.admin.service.impl;

import org.overtime.admin.bean.domain.AdminUser;
import org.overtime.admin.bean.dto.AdminUserListQueryDTO;
import org.overtime.admin.bean.vo.AdminUserListQueryParamVO;
import org.overtime.admin.bean.vo.AuthVO;
import org.overtime.admin.bean.vo.RoleVO;
import org.overtime.admin.bean.vo.RouteVO;
import org.overtime.admin.repository.AdminAuthRepository;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.repository.AdminRouteRepository;
import org.overtime.admin.repository.AdminUserRepository;
import org.overtime.admin.service.AdminUserService;
import org.overtime.common.service.StandardR2dbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.core.StatementMapper;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.CriteriaDefinition;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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
    public Flux<AdminUser> queryUserPaged(AdminUserListQueryDTO queryDTO) {
        // final AdminUserRepository repository = getRepository();
        System.out.println(template);
        // Criteria.where("")

        var baseTableName = "ad_user";
        var sqlBuilder = new StringBuilder("SELECT id, username, password, create_time, status FROM admin_user ").append(baseTableName).append(" ");
        queryDTO.join(baseTableName, sqlBuilder);

        // System.out.println(sqlBuilder);

        var genericExecuteSpec = databaseClient.sql(sqlBuilder.toString());
        return queryDTO.bind(genericExecuteSpec).map((row) -> {
            var id = row.get("id", Integer.class);
            var username = row.get("username", String.class);
            var password = row.get("password", String.class);
            var createTime = row.get("create_time", LocalDateTime.class);
            var status = row.get("status", Short.class);
            return new AdminUser(id, username, password, createTime, status);
        }).all();

        // statementMapper.createSelect("admin_user")
        //         .doWithTable((t, s) -> {
        //
        //         });
        //
        //
        // Mono.from(connectionFactory.create())
        //         .flatMap(c -> {
        //             var builder = new StringBuilder("""
        //                     SELECT id, username, password, create_time, status FROM admin_user
        //                     """);
        //             queryDTO.join(builder);
        //             var statement = c.createStatement(builder.toString()); //.bind()
        //             return Mono.from(queryDTO.bind(statement).execute()).doFinally(st -> c.close());
        //         }).flatMapMany(result -> result.map((row, metadata) -> {
        //
        //
        //             return "";
        //         }));
        //
        //
        //
        // final Pageable pageable = queryDTO.getPageable();
        // return repository.findAdminUser(pageable.getOffset(), pageable.getPageSize());

    }
}