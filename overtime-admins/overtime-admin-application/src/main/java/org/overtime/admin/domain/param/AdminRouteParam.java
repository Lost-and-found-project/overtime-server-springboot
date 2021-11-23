package org.overtime.admin.domain.param;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.domain.Param;

/**
 * 查询具体路由用的请求参数。
 *
 * @author ForteScarlet
 * @see org.overtime.admin.domain.entity.AdminRoute
 */
@Data
public class AdminRouteParam implements Param {

    @Nullable
    private Integer id;
    @Nullable
    private Integer parentId;

}
