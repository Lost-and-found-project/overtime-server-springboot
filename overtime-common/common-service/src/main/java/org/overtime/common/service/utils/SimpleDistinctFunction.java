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
 * A distinct function, like:
 * {@code functionName(DISTINCT ...)}.
 *
 * {@code COUNT(DISTINCT ...)}
 *
 * @see SimpleFunction
 * @see Expression
 * @author ForteScarlet
 */
@SuppressWarnings("JavadocReference")
public class SimpleDistinctFunction implements Expression {
    private final String functionName;
    private final List<Expression> expressions;

    private SimpleDistinctFunction(String functionName, List<Expression> expressions) {
        this.functionName = functionName;
        this.expressions = expressions;
    }


    public static SimpleDistinctFunction create(String functionName, Expression... expressions) {
        return new SimpleDistinctFunction(functionName, Arrays.asList(expressions));
    }



    public static SimpleDistinctFunction count(Expression... expressions) {
        return new SimpleDistinctFunction("COUNT", Arrays.asList(expressions));
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Expression> getExpressions() {
        return Collections.unmodifiableList(expressions);
    }

    @Override
    public @NotNull String toString() {
        return functionName + "(DISTINCT " + StringUtils.collectionToDelimitedString(expressions, ", ") + ")";
    }

    /**
     * @see org.springframework.data.relational.core.sql.AbstractSegment
     */
    @Override
    public void visit(@NotNull Visitor visitor) {
        Assert.notNull(visitor, "Visitor must not be null!");

        visitor.enter(this);
        visitor.leave(this);
    }

    /**
     * @see org.springframework.data.relational.core.sql.AbstractSegment
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * @see org.springframework.data.relational.core.sql.AbstractSegment
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Segment && toString().equals(obj.toString());
    }
}
