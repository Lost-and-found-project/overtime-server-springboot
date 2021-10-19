package org.overtime.compensate;

import org.overtime.common.controller.SpringApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * @author ForteScarlet
 */
public class CompensateApplication {
    public static void main(String[] args) {
        SpringApp.runStandardResourcesApi(args);
        // SpringApplication.run(CompensateApplication.class, args);
    }
}
