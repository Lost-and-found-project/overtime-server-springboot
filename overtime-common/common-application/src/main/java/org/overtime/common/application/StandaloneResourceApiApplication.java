package org.overtime.common.application;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import reactivefeign.spring.config.EnableReactiveFeignClients;

/**
 * 没有服务发现的资源API。只携带着异常处理。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("ALL")
@OvertimeStandardApplication
// Overtime handler
@EnableOvertimeHandler(resultHandler = false)
@EnableReactiveFeignClients(basePackages = "org.overtime.*.api") // Compile only
// @EnableFeignClients(basePackages = "org.overtime.*.api") // Compile only
public abstract class StandaloneResourceApiApplication {
}
