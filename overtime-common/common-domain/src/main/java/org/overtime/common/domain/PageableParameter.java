package org.overtime.common.domain;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * 分页请求参数。默认为第一页、每页10条。
 *
 * @author ForteScarlet
 * @see PageRequest#of(int, int)
 */
@Data
public class PageableParameter {

    /**
     * 以0为起点的页码。
     */
    private Integer page;

    /**
     * 当页数量。
     */
    private Integer pageSize;

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 10;

    public Pageable pageable() {
        if (page == null && pageSize == null) {
            return PageRequest.of(DEFAULT_PAGE, DEFAULT_PAGE_SIZE);
        } else {
            var size0 = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
            var page0 = page == null ? DEFAULT_PAGE : page;
            if (page0 < 0) {
                page0 = 0;
            }
            return PageRequest.of(page0, size0);
        }
    }

}
