package org.overtime.common.domain;

import lombok.Data;

/**
 * 请求参数中，记录所需分页信息的参数。
 *
 * @author ForteScarlet
 */
@Data
public class PageInfo {
    private int page;
    private int pageSize;


}
