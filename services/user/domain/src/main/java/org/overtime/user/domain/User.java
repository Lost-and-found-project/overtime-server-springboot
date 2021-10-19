package org.overtime.user.domain;

import org.intellij.lang.annotations.Identifier;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 用户实体
 * @author ForteScarlet
 */
@Table
public record User(
        @Id
        Long id,
        String username,
        String password,
        String email,
        String phone,
        LocalDateTime createTime,
        Integer status
) {
}
