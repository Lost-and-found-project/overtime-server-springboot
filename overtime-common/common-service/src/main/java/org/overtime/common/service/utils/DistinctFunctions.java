package org.overtime.common.service.utils;

import org.springframework.data.relational.core.sql.Expression;

/**
 * @author ForteScarlet
 */
public final class DistinctFunctions {

    public static SimpleDistinctFunction count(Expression... expressions) {
        return CountDistinctFunction.getInstance(expressions);
    }
}
