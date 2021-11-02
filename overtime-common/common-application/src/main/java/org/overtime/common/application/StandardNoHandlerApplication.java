package org.overtime.common.application;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactivefeign.spring.config.EnableReactiveFeignClients;

/**
 * 基础的无 {@link EnableOvertimeHandler} 的Controller。
 *
 * @author ForteScarlet
 */
@OvertimeStandardApplication
@EnableDiscoveryClient
// Overtime handler
@EnableReactiveFeignClients(basePackages = "org.overtime.*.api") // Compile only
// @EnableFeignClients(basePackages = "org.overtime.*.api") // Compile only
public abstract class StandardNoHandlerApplication {
}
