package org.overtime.common;

import org.jetbrains.annotations.NotNull;

/**
 * 给一些自定义异常所使用的，能够提供 code 与 message 信息。
 *
 * @author ForteScarlet
 */
public interface CodeMessageSupport {
    /**
     * 得到错误码。
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 可以指定一个http响应的错误码。
     *
     * @return http response code.
     */
    default int getHttpResponseStatus() {
        return 500;
    }

    /**
     * 得到错误信息。
     *
     * @return 错误信息
     */
    @NotNull String getMessage();
}
