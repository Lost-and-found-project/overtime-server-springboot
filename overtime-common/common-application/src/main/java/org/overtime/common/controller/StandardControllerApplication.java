package org.overtime.common.controller;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
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
