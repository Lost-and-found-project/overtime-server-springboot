package org.overtime.common.application;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import reactivefeign.spring.config.EnableReactiveFeignClients;

/**
 * 没有注册发现的无 {@link EnableOvertimeHandler} 的Controller。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("ALL")
@OvertimeStandardApplication
@EnableReactiveFeignClients(basePackages = "org.overtime.*.api") // Compile only
// @EnableFeignClients(basePackages = "org.overtime.*.api") // Compile only
public abstract class StandaloneNoHandlerApplication {
}
