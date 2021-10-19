package org.overtime.dictionary;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.overtime.dictionary.api.DictionaryApiSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * @author ForteScarlet
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableR2dbcAuditing
@EnableR2dbcRepositories(basePackages = "org.overtime.*.repository")
@ComponentScan("org.overtime.*.repository")
@ComponentScan("org.overtime.*.controller")
@ComponentScan("org.overtime.*.service")
// @ComponentScan("org.overtime.*.api")
@EnableDiscoveryClient
// Overtime handler
@EnableOvertimeHandler(resultHandler = false)
@EnableFeignClients(basePackages = "org.overtime.*.api")
public class DictionaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
        // SpringApp.runStandardResourcesApi(args, DictionaryApplication.class);
    }
}
