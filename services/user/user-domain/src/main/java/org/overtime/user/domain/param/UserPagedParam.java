package org.overtime.user.domain.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.overtime.user.domain.entity.User;
import org.springframework.data.domain.Pageable;

/**
 *
 * 用户分页查询参数。
 *
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPagedParam extends User {

}
