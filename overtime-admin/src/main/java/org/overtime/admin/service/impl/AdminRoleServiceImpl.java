package org.overtime.admin.service.impl;

import org.overtime.admin.bean.domain.AdminRole;
import org.overtime.admin.repository.AdminRoleRepository;
import org.overtime.admin.service.AdminRoleService;
import org.overtime.common.service.StandardR2dbcService;
import org.springframework.stereotype.Service;

/**
 * @author ForteScarlet
 */
@Service
public class AdminRoleServiceImpl extends StandardR2dbcService<AdminRole, Integer, AdminRoleRepository> implements AdminRoleService {
    public AdminRoleServiceImpl(AdminRoleRepository repository) {
        super(repository);
    }


}
