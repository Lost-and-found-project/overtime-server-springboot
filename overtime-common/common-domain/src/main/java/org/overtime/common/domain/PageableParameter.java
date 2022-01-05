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

    private Integer page;
    private Integer pageSize;

    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;

    public Pageable pageable() {
        if (page == null && pageSize == null) {
            return PageRequest.of(DEFAULT_PAGE, DEFAULT_PAGE_SIZE);
        } else {
            var size0 = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
            var page0 = page == null ? DEFAULT_PAGE : page;
            if (page0 <= 0) {
                page0 = 1;
            }
            return PageRequest.of(page0, size0);
        }
    }

}
