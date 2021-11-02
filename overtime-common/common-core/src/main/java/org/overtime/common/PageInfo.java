package org.overtime.common;

import org.springframework.data.domain.Pageable;

/**
 * 用于响应的分页信息数据。
 *
 * @author ForteScarlet
 */
public record PageInfo(
        long total,
        int totalPages,
        int pageNum,
        int pageSize
) {
    public static PageInfo toPageInfo(long total, Pageable pageable) {
        return toPageInfo(total, pageable.getPageSize(), pageable.getPageNumber());
    }

    public static PageInfo toPageInfo(long total, int pageSize, int pageNumber) {
        return new PageInfo(total, getTotalPages(pageSize, total), pageNumber + 1, pageSize);
    }

    private static int getTotalPages(int size, long total) {
        return size == 0 ? 1 : (int) Math.ceil((double) total / (double) size);
    }
}
