package org.overtime.domain;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 补偿类型。每一次的补偿记录对应一个补偿类型。
 *
 * <p>
 * <p>
 *
 * @param userId 与之关联的用户ID。
 * @author ForteScarlet
 * @see Compensate
 */
// @Data
// @NoArgsConstructor
@Table
public record CompensateType(
        @Id
        @NotNull
        Long id,

        /*
          与之关联的用户ID。
         */
        @NotNull
        Long userId,

        /*
          补偿类型的名称。
         */
        @NotNull
        String name,

        /*
          补偿类型的单位。
         */
        @NotNull
        String unit,

        /*
          <p> 比例。指 {@code 1min * proportion = compensate}. 即一分钟与当前补偿之间的比例.

          <p> 以调休为例, 假设调休1分钟顶2分钟的加班, 则说明 {@code 2min加班 * proportion = 1调休}, 则 {@code proportion = 0.5}.
         */
        @NotNull
        BigDecimal proportion,

        /*
          描述说明。
         */
        @NotNull
        String description,


        /*
          <p> 类型。
          <p> <b>暂未确定类型元素与含义。</b>
          <p> TODO 例如.. 0: 普通, 1: 临时?
          <p>
          // tinyint
         */
        int type,


        /*
          创建时间。
         */
        @NotNull
        LocalDateTime createTime,

        /*
          最后一次修改时间。
         */
        @NotNull
        LocalDateTime lastModifiedTime
) {

}
