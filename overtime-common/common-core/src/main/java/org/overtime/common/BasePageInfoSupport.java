package org.overtime.common;

import lombok.Data;

/**
 * 请求参数中，记录所需分页信息的参数。
 *
 * @author ForteScarlet
 */
@Data
public class BasePageInfoSupport implements PageInfoSupport {
    private int page = DEFAULT_PAGE;
    private int pageSize = DEFAULT_PAGE_SIZE;
}
