package org.overtime.common.controller;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 *
 * 不启用服务发现的对外Controller。带着异常处理和返回值处理。
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
@EnableOvertimeHandler
@EnableFeignClients(basePackages = "org.overtime.*.api") // Compile only
public abstract class StandaloneControllerApplication {
}
