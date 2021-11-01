package org.overtime.user.domain.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.overtime.common.PageInfoSupport;
import org.overtime.user.domain.entity.User;

/**
 *
 * 用户分页查询参数。
 *
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPagedParam extends User implements PageInfoSupport {
    private int page = DEFAULT_PAGE;
    private int pageSize = DEFAULT_PAGE_SIZE;


}
