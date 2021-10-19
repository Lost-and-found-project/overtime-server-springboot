package org.overtime.dictionary;

import org.overtime.common.controller.SpringApp;
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
 * Dictionary application.
 * @author ForteScarlet
 */
@SpringBootApplication // Unused yet.
public class DictionaryApplication {
    public static void main(String[] args) {
        SpringApp.runStandardResourcesApi(args);
    }
}
