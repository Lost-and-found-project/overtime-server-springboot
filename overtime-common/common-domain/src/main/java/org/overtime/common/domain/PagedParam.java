package org.overtime.common.domain;

/**
 *
 * 存在分页数据的查询参数。
 *
 * @author ForteScarlet
 */
public interface PagedParam extends Param {

    /**
     * 获取页码。
     * @return page
     */
    int getPage();

    /**
     * 获取单页大小。
     * @return page size
     */
    int getPageSize();



}
