package org.overtime;

import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * Spring application.
 *
 * @author ForteScarlet
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableR2dbcRepositories
@EnableR2dbcAuditing
@EnableOvertimeHandler
public class OvertimeServerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OvertimeServerApplication.class, args);

    }
}
