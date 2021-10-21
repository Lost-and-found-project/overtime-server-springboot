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
import org.springframework.data.r2dbc.dialect.R2dbcDialect;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public AdminUserServiceImpl(AdminUserRepository repository, R2dbcEntityTemplate template, AdminRoleRepository roleRepository, AdminAuthRepository authRepository, AdminRouteRepository routeRepository) {
        super(repository);
        this.template = template;
        this.roleRepository = roleRepository;
        this.authRepository = authRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Mono<AdminUserListQueryParamVO> getUserListQueryParam() {
        // TODO
        //  see https://docs.spring.io/spring-data/r2dbc/docs/1.3.5/reference/html/#r2dbc.repositories.queries

        final var roles = roleRepository.findAll().map(RoleVO::byRole).collectList();
        final var auths = authRepository.findAll().map(AuthVO::byAuth).collectList();
        final var routes = routeRepository.findAll().map(RouteVO::byRoute).collectList();


        return Mono.zip(roles, auths, routes).map((tuple) -> new AdminUserListQueryParamVO(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }

    @Override
    public Flux<AdminUser> queryUserPaged(AdminUserListQueryDTO queryDTO) {

        final AdminUserRepository repository = getRepository();


        // template.select(AdminUser.class).from("admin_user").matching(
        //         Query.query(Criteria.where("name").is("a"))
        // )

        // System.out.println(queryDTO);
        //
        //
        // Query.empty().columns("id", "username", "password", "status", "create_time")
        //         .
        //                 .with(queryDTO.getPageable());
        //
        // template.select()
        //
        // template.select(AdminUser.class).one()

        // return template.select(AdminUser.class).all().limitRate(queryDTO.getPage(), queryDTO.getSize());


        final Pageable pageable = queryDTO.getPageable();
        return repository.selectAdminUser(pageable.getOffset(), pageable.getPageSize());

    }
}