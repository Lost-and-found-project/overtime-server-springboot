package org.overtime.dictionary;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * @author ForteScarlet
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableR2dbcRepositories
@EnableR2dbcAuditing

@EnableDiscoveryClient
// Overtime handler
// @EnableOvertimeHandler
public class DictionaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
    }
}
