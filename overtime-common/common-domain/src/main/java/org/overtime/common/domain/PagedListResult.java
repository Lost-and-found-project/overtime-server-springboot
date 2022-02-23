package org.overtime.common.domain;

import lombok.Value;

import java.util.List;

/**
 * 分页后的数据封装类.
 * @author ForteScarlet
 */
@Value
public class PagedListResult<T> {
    /**
     * 数据总量
     */
    long total;


    /**
     * 数据列表
     */
    List<T> list;



}
