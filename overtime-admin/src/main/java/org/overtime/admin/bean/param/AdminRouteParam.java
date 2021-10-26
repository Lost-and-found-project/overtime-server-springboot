package org.overtime.admin.bean.param;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
import org.overtime.common.domain.Param;

/**
 * 查询具体路由用的请求参数。
 *
 * @see org.overtime.admin.bean.domain.AdminRoute
 * @author ForteScarlet
 */
@Data
public class AdminRouteParam implements Param {

    @Nullable
    private Integer id;
    @Nullable
    private Integer parentId;

}
