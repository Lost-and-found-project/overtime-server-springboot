package org.overtime.user.domain.entity;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
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
    private LocalDateTime createTime;
    private Integer status;
}
