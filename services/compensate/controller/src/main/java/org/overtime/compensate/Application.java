package org.overtime.compensate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * @author ForteScarlet
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "org.overtime.repository")
@EnableR2dbcAuditing
@ComponentScan("org.overtime.service.**")
@ComponentScan("org.overtime.**.service.**")
@ComponentScan("org.overtime.**.controller")
// @ComponentScan("org.overtime.configuration.**")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
