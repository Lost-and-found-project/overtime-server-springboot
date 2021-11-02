package org.overtime.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * 允许得到分页信息
 *
 * @author ForteScarlet
 */
public interface PageInfoSupport {

    /**
     * 页码应由 1 开始。
     */
    int DEFAULT_PAGE = 1;

    /**
     * 默认一页10条。
     */
    int DEFAULT_PAGE_SIZE = 10;

    /**
     * 获取页码。
     *
     * @return page
     */
    int getPage();

    /**
     * 获取单页数据量。
     *
     * @return page size.
     */
    int getPageSize();

    // TODO sort?

    /**
     * 得到一个分页信息。
     *
     * @return pageable
     * @see Pageable
     */
    default Pageable pageable() {
        return PageRequest.of(getPage() - 1, getPageSize());
    }


}
