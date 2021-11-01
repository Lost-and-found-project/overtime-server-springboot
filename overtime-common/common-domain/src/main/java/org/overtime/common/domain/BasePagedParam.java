package org.overtime.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基础的分页查询参数。
 * <p>
 * {@code param}: 条件查询参数
 * {@code page}: 分页参数
 *
 * @author ForteScarlet
 */
@Getter
@Setter
@ToString
public class BasePagedParam<D> {
    private D param;
    private PageInfo page;
}
