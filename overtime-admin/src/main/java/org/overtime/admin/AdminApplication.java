package org.overtime.admin;

import org.overtime.common.application.OvertimeStandardApplication;
import org.overtime.common.application.SpringApp;
import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ForteScarlet
 */
@EnableOvertimeHandler
@OvertimeStandardApplication
@EnableDiscoveryClient
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        // SpringApp.runStandardController(args);
    }



}
