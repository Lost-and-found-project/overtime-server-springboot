package org.overtime.common;

/**
 * 分页后的数据信息。
 * @author ForteScarlet
 */
public record Paged<T>(
        T data,
        PageInfo pageInfo
) {
}
