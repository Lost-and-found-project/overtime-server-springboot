package org.overtime.admin;

import org.overtime.common.application.OvertimeStandardApplication;
import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactivefeign.spring.config.EnableReactiveFeignClients;

/**
 * @author ForteScarlet
 */
@EnableOvertimeHandler
@OvertimeStandardApplication
@EnableDiscoveryClient
@EnableReactiveFeignClients(basePackages = "org.overtime.*.api")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }


}
