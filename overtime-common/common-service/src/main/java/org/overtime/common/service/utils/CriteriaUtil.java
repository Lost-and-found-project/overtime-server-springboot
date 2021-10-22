package org.overtime.common.service.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.function.BiFunction;

/**
 * @author ForteScarlet
 * <p>
 * critters
 */
@SuppressWarnings("unused")
public final class CriteriaUtil {


    @NotNull
    @Contract(pure = true)
    public static <V> Criteria notNull(@NotNull Criteria criteria, String column, @Nullable V value, BiFunction<Criteria.CriteriaStep, @NotNull V, Criteria> function) {
        if (value == null) {
            return criteria;
        }

        return criteria.and(function.apply(Criteria.where(column), value));
    }


    @NotNull
    @Contract(pure = true)
    public static <S extends CharSequence> Criteria notEmpty(@NotNull Criteria criteria, String column, @Nullable S value, BiFunction<Criteria.CriteriaStep, @NotNull S, Criteria> function) {
        if (value == null || value.toString().isEmpty()) {
            return criteria;
        }

        return criteria.and(function.apply(Criteria.where(column), value));
    }

    @NotNull
    @Contract(pure = true)
    public static <S extends CharSequence> Criteria notBlank(@NotNull Criteria criteria, String column, @Nullable S value, BiFunction<Criteria.CriteriaStep, @NotNull S, Criteria> function) {
        if (value == null || value.toString().isBlank()) {
            return criteria;
        }

        return criteria.and(function.apply(Criteria.where(column), value));
    }


    @NotNull
    @Contract(pure = true)
    public static <C extends Collection<?>> Criteria notEmpty(@NotNull Criteria criteria, String column, @Nullable C value, BiFunction<Criteria.CriteriaStep, @NotNull C, Criteria> function) {
        if (value == null || value.isEmpty()) {
            return criteria;
        }

        return criteria.and(function.apply(Criteria.where(column), value));
    }

    /**
     * 使用 {@link Criteria#and(String)} {@link org.springframework.data.relational.core.query.Criteria.CriteriaStep#in(Object...)}
     * 对 {@code values} 进行匹配：如果 {@code values} 不为空的话。
     *
     * @param criteria criteria
     * @param column   column
     * @param values   In values.
     * @return criteria
     */
    @NotNull
    @Contract(pure = true)
    public static Criteria andInIfNotEmpty(@NotNull Criteria criteria, String column, @Nullable Collection<?> values) {
        if (values == null || values.isEmpty()) {
            return criteria;
        }
        return criteria.and(Criteria.where(column).in(values));
    }


}
