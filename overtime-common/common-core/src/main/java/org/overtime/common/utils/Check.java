package org.overtime.common.utils;

import org.jetbrains.annotations.Contract;

/**
 * 检查验证工具类。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("unused")
public final class Check {

    @Contract("null,_ -> fail")
    public static void notnull(Object v, String name) {
        if (v == null) {
            throw new NullPointerException("'" + name + "' must not null.");
        }
    }

    @Contract("null -> fail")
    public static void notnull(Object v) {
        if (v == null) {
            throw new NullPointerException("value must not null.");
        }
    }

    @Contract("null,_ -> fail")
    public static void requireNotnull(Object v, String name) {
        if (v == null) {
            // illegal argument(null pointer)
            throw new IllegalArgumentException("Required '" + name + "' was null.");
        }
    }


    @Contract("null -> fail")
    public static void requireNotnull(Object v) {
        if (v == null) {
            // illegal argument(null pointer)
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    @Contract("false,_ -> fail")
    public static void require(boolean check, String msg) {
        if (!check) {
            throw new IllegalArgumentException(msg);
        }
    }


    @Contract("false -> fail")
    public static void require(boolean check) {
        if (!check) {
            throw new IllegalArgumentException("Required check failed.");
        }
    }


}
