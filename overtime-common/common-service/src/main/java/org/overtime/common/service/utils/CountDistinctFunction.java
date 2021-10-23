package org.overtime.common.service.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Segment;
import org.springframework.data.relational.core.sql.SimpleFunction;
import org.springframework.data.relational.core.sql.Visitor;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Function: {@code COUNT(DISTINCT ... )}
 *
 * @see org.springframework.data.relational.core.sql.Functions
 * @see org.springframework.data.relational.core.sql.SimpleFunction
 * @author ForteScarlet
 */
public class CountDistinctFunction extends SimpleDistinctFunction implements Expression {
    private static final String FUNCTION_NAME = "COUNT";
    private final List<Expression> expressions;

    private CountDistinctFunction(List<Expression> expressions) {
        super(FUNCTION_NAME, expressions);
        this.expressions = expressions;
    }

    public static CountDistinctFunction getInstance(Expression... expressions) {
        return new CountDistinctFunction(Arrays.asList(expressions));
    }

    /**
     * @see SimpleFunction#toString()
     */
    @Override
    public @NotNull String toString() {
        return FUNCTION_NAME + "(DISTINCT " + StringUtils.collectionToDelimitedString(expressions, ", ") + ")";
    }

    /**
     * @see SimpleFunction#getFunctionName()
     */
    public String getFunctionName() {
        return FUNCTION_NAME;
    }

    /**
     * @see SimpleFunction#getExpressions()
     */
    public List<Expression> getExpressions() {
        return Collections.unmodifiableList(expressions);
    }


    /**
     * @see org.springframework.data.relational.core.sql.AbstractSegment
     */
    @SuppressWarnings("JavadocReference")
    @Override
    public void visit(@NotNull Visitor visitor) {
        Assert.notNull(visitor, "Visitor must not be null!");

        visitor.enter(this);
        visitor.leave(this);
    }

    /**
     * @see org.springframework.data.relational.core.sql.AbstractSegment
     */
    @SuppressWarnings("JavadocReference")
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * @see org.springframework.data.relational.core.sql.AbstractSegment
     */
    @SuppressWarnings("JavadocReference")
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Segment && toString().equals(obj.toString());
    }
}
