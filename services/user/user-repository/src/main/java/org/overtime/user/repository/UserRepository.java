package org.overtime.user.repository;

import org.overtime.common.repository.StandardOvertimeRepository;
import org.overtime.user.domain.entity.User;
import org.springframework.stereotype.Repository;

/**
 *
 * User repository
 *
 * @author ForteScarlet
 */
@Repository
public interface UserRepository extends StandardOvertimeRepository<User, Long> {
}
