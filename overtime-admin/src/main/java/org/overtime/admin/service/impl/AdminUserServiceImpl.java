package org.overtime.admin.service.impl;

import org.overtime.admin.bean.domain.AdminUser;
import org.overtime.admin.bean.param.AdminUserListQueryParam;
import org.overtime.admin.bean.param.AdminUserRoleEditParam;
import org.overtime.admin.bean.vo.*;
import org.overtime.admin.repository.AdminAuthRepository;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.repository.AdminRouteRepository;
import org.overtime.admin.repository.AdminUserRepository;
import org.overtime.admin.service.AdminUserService;
import org.overtime.common.Paged;
import org.overtime.common.service.OvertimeR2dbcEntityTemplate;
import org.overtime.common.service.StandardR2dbcService;
import org.overtime.common.service.utils.CriteriaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public AdminUserServiceImpl(AdminUserRepository repository,
                                OvertimeR2dbcEntityTemplate ovTemplate,
                                AdminRoleRepository roleRepository,
                                AdminAuthRepository authRepository,
                                AdminRouteRepository routeRepository) {
        super(repository);
        this.ovTemplate = ovTemplate;
        this.roleRepository = roleRepository;
        this.authRepository = authRepository;
        this.routeRepository = routeRepository;

        // init row mapper
    }

    @Override
    public Mono<AdminUserListQueryParamVO> getUserListQueryParam() {
        final var roles = roleRepository.findAllForQueryParam(RoleVO.class).collectList();
        final var auths = authRepository.findAllForQueryParam(AuthVO.class).collectList();
        final var routes = routeRepository.findAllForQueryParam(RouteVO.class).collectList();


        return Mono.zip(roles, auths, routes).map((tuple) -> new AdminUserListQueryParamVO(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }

    /**
     * 根据参数查询用户列表
     *
     * @param queryDTO params
     * @return Page AdminUser
     */
    @Override
    public Mono<Paged<AdminUserHidePassVO>> queryUserPaged(AdminUserListQueryParam queryDTO) {
        var criteria = Criteria.empty();
        // username.
        criteria = CriteriaUtil.notNull(criteria, "username", queryDTO.getUsername(), (c, v) -> c.like("%" + v + "%"));
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "role_id", queryDTO.getRoles());
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "auth_id", queryDTO.getAuths());
        criteria = CriteriaUtil.andInIfNotEmpty(criteria, "route_id", queryDTO.getRoutes());

        return ovTemplate.selectPaged(AdminUserHidePassVO.class, AdminUserHidePassVO.class, Query.query(criteria)
                .columns("id", "username", "create_time", "status")
                .with(queryDTO.getPageable()), true);
    }

    /**
     * 增加用户的角色，返回增加后的角色ID列表。
     *
     * @param param param
     * @return ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Flux<Integer> addRole(AdminUserRoleEditParam param) {
        if (param.getRoles().isEmpty()) {
            return getUserRoleIds(param.getUserId());
        }

        final Integer userId = param.getUserId();
        final var insert = ovTemplate.getR2dbcEntityTemplate()
                .insert(AdminUserRoleEditParam.Entity.class)
                .into(AdminUserRoleEditParam.Entity.TABLE);

        return param.toEntryFlux().flatMap(insert::using)
                .concatMap(v -> getUserRoleIds(userId));
    }


    /**
     * 移除管理用户的角色，返回移除后的角色ID列表。
     *
     * @param param param
     * @return ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Flux<Integer> removeRole(AdminUserRoleEditParam param) {
        final Integer userId = param.getUserId();
        if (param.getRoles().isEmpty()) {
            return getUserRoleIds(userId);
        }

        final Criteria userIdCriteria = Criteria.where("user_id").is(userId);
        final Criteria rolesCriteria = Criteria.where("roles").in(param.getRoles());
        Query query = Query.query(userIdCriteria.and(rolesCriteria));

        return ovTemplate.getR2dbcEntityTemplate()
                .delete(AdminUserRoleEditParam.Entity.class)
                .from(AdminUserRoleEditParam.Entity.TABLE)
                .matching(query).all().flatMapMany(rows -> getUserRoleIds(userId));
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

