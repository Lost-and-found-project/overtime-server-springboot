package org.overtime.common.controller;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 *
 * 基础的资源API。只携带着异常处理。
 *
 * @author ForteScarlet
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableR2dbcRepositories
@EnableR2dbcAuditing

@EnableDiscoveryClient
// Overtime handler
@EnableOvertimeHandler(resultHandler = false)
public abstract class StandardResourceApiApplication {
}
