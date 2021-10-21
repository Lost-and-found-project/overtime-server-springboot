package org.overtime.admin.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overtime.admin.bean.vo.AuthVO;
import org.overtime.admin.bean.vo.RoleVO;
import org.overtime.admin.bean.vo.RouteVO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/**
 * 所有的角色、权限、路由。
 * 一般用于查询条件。
 *
 * @author ForteScarlet
 */
@Data
public class AdminUserListQueryDTO {
    private String name = "";
    private List<Integer> roles = Collections.emptyList();
    private List<Integer> auths = Collections.emptyList();
    private List<Integer> routes = Collections.emptyList();
    private Integer page = 1;
    private Integer size = 10;

    public Pageable getPageable() {
        return PageRequest.of(getPage() - 1, getSize());
    }

}
