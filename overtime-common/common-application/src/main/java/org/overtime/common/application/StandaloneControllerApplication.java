package org.overtime.common.application;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import reactivefeign.spring.config.EnableReactiveFeignClients;

/**
 * 不启用服务发现的对外Controller。带着异常处理和返回值处理。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("ALL")
@OvertimeStandardApplication
@EnableOvertimeHandler
@EnableReactiveFeignClients(basePackages = "org.overtime.*.api") // Compile only
// @EnableFeignClients(basePackages = "org.overtime.*.api") // Compile only
public abstract class StandaloneControllerApplication {
}
