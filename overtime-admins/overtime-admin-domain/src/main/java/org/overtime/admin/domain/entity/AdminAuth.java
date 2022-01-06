package org.overtime.admin.domain.entity;

import lombok.Data;
import org.overtime.common.auth.AuthInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 管理权限信息
 *
 * @author ForteScarlet
 */
@Table("admin_auth")
@Data
public class AdminAuth implements AuthInfo {
    @Id
    private Integer id;
    private String AdminAuthkey;
    private String name;
    private LocalDateTime createTime;


}
