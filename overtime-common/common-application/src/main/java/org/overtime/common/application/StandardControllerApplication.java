package org.overtime.common.application;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactivefeign.spring.config.EnableReactiveFeignClients;

/**
 *
 * 基础的对外Controller。带着异常处理和返回值处理。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("ALL")
@OvertimeStandardApplication
@EnableDiscoveryClient
// Overtime handler
@EnableOvertimeHandler
@EnableReactiveFeignClients(basePackages = "org.overtime.*.api") // Compile only
// @EnableFeignClients(basePackages = "org.overtime.*.api") // Compile only
public abstract class StandardControllerApplication {
}
