package org.overtime.user.service.impl;

import org.overtime.common.service.StandardR2dbcService;
import org.overtime.user.domain.entity.User;
import org.overtime.user.repository.UserRepository;
import org.overtime.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service.
 * @author ForteScarlet
 */
@Service
public class UserServiceImpl extends StandardR2dbcService<User, Long, UserRepository> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }



}
