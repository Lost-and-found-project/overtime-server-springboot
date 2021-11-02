package org.overtime.admin.bean.param;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 管理用户操作管理权限的参数，用于增加或删除
 *
 * @author ForteScarlet
 */
@Data
public final class AdminUserRoleEditParam {
    private Integer userId;
    private List<Integer> roles;

    /**
     *
     */
    public AdminUserRoleEditParam(
            Integer userId,
            List<Integer> roles
    ) {
        this.userId = userId;
        this.roles = roles;
    }

    @Table(Entity.TABLE)
    public static record Entity(@Id int userId, int roleId) {
        public static final String TABLE = "admin_user_role";
    }

    public List<Entity> toEntryList() {
        return roles.stream().map(rId -> new Entity(userId, rId)).collect(Collectors.toList());
    }

    public Flux<Entity> toEntryFlux() {
        return Flux.fromIterable(roles).map(rId -> new Entity(userId, rId));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AdminUserRoleEditParam) obj;
        return Objects.equals(this.userId, that.userId) &&
                Objects.equals(this.roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roles);
    }

    @Override
    public String toString() {
        return "AdminUserRoleEditParam[" +
                "userId=" + userId + ", " +
                "roles=" + roles + ']';
    }


}
