package org.overtime.admin;

import org.overtime.common.controller.OvertimeStandardApplication;
import org.overtime.common.controller.SpringApp;
import org.overtime.configuration.handler.EnableOvertimeHandler;
import org.overtime.configuration.r2dbc.OvertimeR2dbcEntityTemplateConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author ForteScarlet
 */
@EnableOvertimeHandler
@OvertimeStandardApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApp.runStandardController(args, ConfigOvr2dbc.class);
    }


    @Import(OvertimeR2dbcEntityTemplateConfiguration.class) // TODO
    static class ConfigOvr2dbc {}
}
