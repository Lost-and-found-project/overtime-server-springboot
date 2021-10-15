package org.overtime.common;

import org.jetbrains.annotations.NotNull;

/**
 * <p> 为面向外部的 rest controller 所使用的统一格式的数据返回值。
 * 不应在Resources中使用，在Controller中建议使用统一拦截器。
 *
 * <p> {@link #message} 不应该为null。
 * <p>
 * 只能通过静态方法获取实例。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("unused")
public class Result {
    private static int defaultSuccessCode = 0;
    @NotNull
    private static String defaultSuccessMsg = "Ok";

    private static int defaultFailureCode = -1;
    @NotNull
    private static String defaultFailureMsg = "Failure";
    /**
     * 默认成功的实例。
     */
    public static final Result SUCCESS = new DefaultSuccessResult();
    /**
     * 默认失败的实例。
     */
    public static final Result FAILURE = new DefaultFailureResult();

    private static class DefaultSuccessResult extends Result {
        private DefaultSuccessResult() {
            super(defaultSuccessCode, defaultSuccessMsg, null);
        }

        @Override
        public int getCode() {
            return defaultSuccessCode;
        }

        @Override
        public @NotNull String getMessage() {
            return defaultSuccessMsg;
        }

        @Override
        public Object getData() {
            return null;
        }
    }


    private static class DefaultFailureResult extends Result {
        private DefaultFailureResult() {
            super(defaultSuccessCode, defaultSuccessMsg, null);
        }

        @Override
        public int getCode() {
            return defaultSuccessCode;
        }

        @Override
        public @NotNull String getMessage() {
            return defaultSuccessMsg;
        }

        @Override
        public Object getData() {
            return null;
        }
    }

    /**
     * 设置默认成功情况下的成功码。全局设置，立即生效，包括已经获取过的实例。
     *
     * @param code 默认成功码
     */
    public static void setDefaultSuccessCode(int code) {
        defaultSuccessCode = code;
    }

    /**
     * 设置默认成功情况下的成功消息。全局设置，立即生效，包括已经获取过的实例。
     *
     * @param msg 默认成功消息。
     */
    public static void setDefaultSuccessMsg(@NotNull String msg) {
        Result.defaultSuccessMsg = msg;
    }

    public static void setDefaultFailureCode(int defaultFailureCode) {
        Result.defaultFailureCode = defaultFailureCode;
    }

    public static void setDefaultFailureMsg(@NotNull String defaultFailureMsg) {
        Result.defaultFailureMsg = defaultFailureMsg;
    }

    public static Result success() {
        return SUCCESS;
    }


    public static Result success(Object data) {
        if (data == null) {
            return success();
        }

        return new Result(defaultSuccessCode, defaultSuccessMsg, data);
    }

    // Failed methods

    public static Result failure() {
        return FAILURE;
    }

    public static Result failure(int code, @NotNull String msg) {
        if (FAILURE.code == code && FAILURE.message.equals(msg)) {
            return FAILURE;
        }
        return failure(code, msg, null);
    }

    public static Result failure(int code) {
        if (FAILURE.code == code) {
            return FAILURE;
        }
        return failure(code, FAILURE.message, null);
    }


    public static Result failure(String msg) {
        if (FAILURE.message.equals(msg)) {
            return FAILURE;
        }
        return failure(FAILURE.code, msg, null);
    }

    public static Result failure(int code, @NotNull String msg, Object data) {
        if (data == null && FAILURE.code == code && FAILURE.message.equals(msg)) {
            return FAILURE;
        }
        return new Result(code, msg, data);
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
