package org.overtime.common;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.function.Function;

/**
 * <p> 为面向外部的 rest controller 所使用的统一格式的数据返回值。
 * 不应在Resources中使用，在Controller中建议使用统一拦截器。
 *
 * <p> {@link #message} 不应该为null。
 * <p>
 * 只应通过静态方法获取实例。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("unused")
public sealed class Result implements Serializable {
    private static int defaultSuccessCode = 0;
    @NotNull
    private static String defaultSuccessMsg = "Ok";

    private static int defaultFailureCode = -1;
    @NotNull
    private static String defaultFailureMsg = "Failure";
    /**
     * 默认成功的实例。
     */
    public static Result SUCCESS = null;

    /**
     * 默认失败的实例。
     */
    public static Result FAILURE = null;

    private static final class DefaultSuccessResult extends Result {
        private DefaultSuccessResult() {
            super(defaultSuccessCode, defaultSuccessMsg, null);
        }
    }


    private static final class DefaultFailureResult extends Result {
        private DefaultFailureResult() {
            super(defaultFailureCode, defaultFailureMsg, null);
        }
    }


    /**
     * 设置默认成功情况下的成功码。全局设置，立即生效，包括已经获取过的实例。
     *
     * @param code 默认成功码
     */
    public static void setDefaultSuccessCode(int code) {
        Result.defaultSuccessCode = code;
        SUCCESS = null;
    }

    /**
     * 设置默认成功情况下的成功消息。全局设置，立即生效，包括已经获取过的实例。
     *
     * @param msg 默认成功消息。
     */
    public static void setDefaultSuccessMsg(@NotNull String msg) {
        Result.defaultFailureMsg = msg;
        FAILURE = null;
    }

    public static void setDefaultFailureCode(int defaultFailureCode) {
        Result.defaultFailureCode = defaultFailureCode;
        FAILURE = null;
    }

    public static void setDefaultFailureMsg(@NotNull String defaultFailureMsg) {
        Result.defaultFailureMsg = defaultFailureMsg;
        FAILURE = null;
    }

    private static @NotNull Result getDefaultSuccess() {
        final Result success = SUCCESS;
        if (success == null) {
            final DefaultSuccessResult newSuccess = new DefaultSuccessResult();
            SUCCESS = newSuccess;
            return newSuccess;
        }
        return success;
    }

    public static Result success() {
        return getDefaultSuccess();
    }


    public static Result success(String message, Object data) {
        if (defaultSuccessMsg.equals(message) && data == null) {
            return success();
        }

        return new Result(defaultSuccessCode, message, data);
    }

    public static Result success(Object data) {
        if (data == null) {
            return success();
        }

        return new Result(defaultSuccessCode, defaultSuccessMsg, data);
    }

    public static <T> Function<T, Result> asSuccess() {
        return Result::success;
    }

    public static <T> Function<T, Result> asSuccess(String message) {
        return (t) -> success(message, t);
    }

    // Failed methods

    private static @NotNull Result getDefaultFailure() {
        final Result failure = FAILURE;
        if (failure == null) {
            final DefaultFailureResult newFailure = new DefaultFailureResult();
            FAILURE = newFailure;
            return newFailure;
        }
        return failure;
    }

    public static Result failure() {
        return getDefaultFailure();
    }

    public static Result failure(int code, @NotNull String msg) {
        if (defaultFailureCode == code && defaultFailureMsg.equals(msg)) {
            return failure();
        }
        return failure(code, msg, null);
    }

    public static Result failure(int code) {
        if (defaultFailureCode == code) {
            return failure();
        }
        return failure(code, defaultFailureMsg, null);
    }


    public static Result failureWithMessage(String msg) {
        if (defaultFailureMsg.equals(msg)) {
            return failure();
        }
        return failure(defaultFailureCode, msg, null);
    }


    public static Result failure(int code, @NotNull String msg, Object data) {
        if (data == null && defaultFailureCode == code && defaultFailureMsg.equals(msg)) {
            return failure();
        }
        return new Result(code, msg, data);
    }

    public static Result failure(Object data) {
        if (data == null) {
            return failure();
        }
        return new Result(defaultFailureCode, defaultFailureMsg, data);
    }

    public static <T> Function<T, Result> asFailure(int code) {
        return (t) -> Result.failure(code, defaultFailureMsg, t);
    }


    public static <T> Function<T, Result> asFailure(String message) {
        return (t) -> Result.failure(defaultFailureCode, defaultFailureMsg, t);
    }

    public static <T> Function<T, Result> asFailure() {
        return Result::failure;
    }


    // ******************** Instance ********************* //


    private final int code;
    @NotNull
    private final String message;
    private final Object data;


    private Result(int code, @NotNull String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public @NotNull String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Result(" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ')';
    }
}
