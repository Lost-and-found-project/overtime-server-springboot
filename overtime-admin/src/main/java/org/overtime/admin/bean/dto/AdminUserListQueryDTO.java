package org.overtime.admin.bean.dto;

import io.r2dbc.spi.Statement;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.r2dbc.core.DatabaseClient;

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



    public void join(String baseTableName, StringBuilder builder) {
        // if (values != null && !values.isEmpty()) {
        //     switch (type) {
        //         // role
        //         case 1 -> builder.append("LEFT JOIN admin_user_role aur on ")
        //                 .append(baseTableName)
        //                 .append(".id = aur.user_id WHERE aur.role_id IN (?");
        //
        //         case 2 -> builder.append("LEFT JOIN admin_user_role aur on ")
        //                 .append(baseTableName)
        //                 .append("LEFT JOIN admin_role_auth ara on aur.role_id = ara.role_id")
        //                 .append("WHERE ara.auth_id IN (?");
        //
        //         case 3 -> builder.append("LEFT JOIN admin_user_role aur on ")
        //                 .append(baseTableName)
        //                 .append("LEFT JOIN admin_role_auth ara on aur.role_id = ara.role_id")
        //                 .append("LEFT JOIN admin_auth_route aar on ara.auth_id = aar.auth_id")
        //                 .append("WHERE aar.route_id IN (?");
        //
        //         default -> throw new IllegalArgumentException("Type must in 1..3, but: " + type);
        //     }
        //     builder.append(", ?".repeat(values.size() - 1)).append(")\n");
        // }
        // var pageable = getPageable();
        // builder.append("LIMIT ").append(pageable.getOffset())
        //         .append(", ").append(pageable.getPageSize());
    }

    public Statement bind(Statement statement) {
        // var statement0 = statement;
        // for (int i = 0; i < values.size(); i++) {
        //     var value = values.get(i);
        //     statement0 = statement0.bind(i, value);
        // }
        // return statement0;
        return statement;
    }

    public DatabaseClient.GenericExecuteSpec bind(DatabaseClient.GenericExecuteSpec spec) {
        // var spec0 = spec;
        // for (int i = 0; i < values.size(); i++) {
        //     var value = values.get(i);
        //     spec0 = spec0.bind(i, value);
        // }
        // return spec0;
        return spec;
    }

}
