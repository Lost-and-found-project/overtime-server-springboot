package org.overtime.common;

import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Sort;

/**
 *
 * 可携带的排序信息。一般以列表为形式出现。
 *
 * @author ForteScarlet
 */
public interface SortInfoSupport {

    /**
     * 排序字段名
     */
    String getName();

    /**
     * 排序方式。
     */
    @Nullable
    Sort.Direction getDirection();


}
