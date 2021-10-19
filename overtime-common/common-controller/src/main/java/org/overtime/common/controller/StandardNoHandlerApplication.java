package org.overtime.common.controller;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 *
 * 基础的无 {@link EnableOvertimeHandler} 的Controller。
 *
 * @author ForteScarlet
 */
@SuppressWarnings("ALL")
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableR2dbcAuditing
@EnableR2dbcRepositories(basePackages = "org.overtime.*.repository")
@ComponentScan("org.overtime.*.repository")
@ComponentScan("org.overtime.*.controller")
@ComponentScan("org.overtime.*.service")
@ComponentScan("org.overtime.*.api")
@EnableDiscoveryClient
// Overtime handler
@EnableFeignClients(basePackages = "org.overtime.*.api") // Compile only
public abstract class StandardNoHandlerApplication {
}
