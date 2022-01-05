package org.overtime.admin.domain.param;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.domain.RequestParameter;

/**
 * 查询具体路由用的请求参数。
 *
 * @author ForteScarlet
 * @see org.overtime.admin.domain.entity.AdminRoute
 */
@Data
public class AdminRouteRequestParameter implements RequestParameter {

    @Nullable
    private Integer id;

    @Nullable
    private Integer parentId;

}
