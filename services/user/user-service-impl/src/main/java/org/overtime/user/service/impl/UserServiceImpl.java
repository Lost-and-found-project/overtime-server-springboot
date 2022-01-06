package org.overtime.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.PageInfoSupport;
import org.overtime.common.Paged;
import org.overtime.common.service.StandardR2dbcService;
import org.overtime.user.domain.entity.User;
import org.overtime.user.domain.entity.UserWithInfo;
import org.overtime.user.repository.UserRepository;
import org.overtime.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User service.
 *
 * @author ForteScarlet
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl extends StandardR2dbcService<User, Long, UserRepository> implements UserService {


    @Override
    public Mono<User>findById(@NotNull Long id) {
        return super.findById(id);
    }

    @Override
    public Flux<User> findAll(@Nullable User user) {
        // TODO create_time?
        return user == null ? findAll() : getRepository().findAll(Example.of(user));
    }


    @Override
    public Mono<Paged<User>> findAllPaged(User user, PageInfoSupport pageInfo) {
        return getOvertimeR2dbcEntityTemplate().selectPaged(Example.of(user), pageInfo);
    }


    @Override
    public Flux<User> findAllPagedList(User user, PageInfoSupport pageInfo) {
        return pagedList(user, User.class, pageInfo.pageable());
    }


    @Override
    public Mono<UserWithInfo> findUserWithInfoById(Long id) {
        return getRepository().findByIdWithInfo(id);
    }
}
