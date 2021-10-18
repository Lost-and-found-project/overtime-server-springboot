package org.overtime.common;

import java.text.MessageFormat;

/**
 *
 * 返回值中的 code - msg 对应值。
 * 一般代表错误码与对应的消息。 {@link #msg} 是一个 {@link MessageFormat}
 *
 * @author ForteScarlet
 */
public record CodeMsg(int code, MessageFormat msg) {
}
