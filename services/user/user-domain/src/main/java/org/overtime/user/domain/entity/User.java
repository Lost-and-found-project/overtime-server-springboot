package org.overtime.user.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 用户表实体。
 *
 * @author ForteScarlet
 */
@Data
@Table("ov_user")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    @CreatedDate
    private LocalDateTime createTime;
    private Integer status;
    @Column("is_admin")
    private Integer admin;


    public boolean isAdmin() {
        return 1 == admin;
    }
}
