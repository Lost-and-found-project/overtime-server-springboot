package org.overtime.admin.bean.param;

import lombok.Data;
import org.overtime.common.domain.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

/**
 * 所有的角色、权限、路由。
 * 一般用于查询条件。
 *
 * @author ForteScarlet
 */
@Data
public class AdminUserListQueryParam implements Param {
    private String username;
    private List<Integer> roles = Collections.emptyList();
    private List<Integer> auths = Collections.emptyList();
    private List<Integer> routes = Collections.emptyList();
    /**
     * 1：values为角色ID列表
     * 2：values为权限ID列表
     * 3：values为路由ID列表
     */
    // private Integer type = 1;
    private Integer page = 1;
    private Integer size = 10;

    public Pageable getPageable() {
        return PageRequest.of(getPage() - 1, getSize());
    }

}
