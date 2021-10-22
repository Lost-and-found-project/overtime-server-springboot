package org.overtime.admin;

import org.overtime.common.controller.OvertimeStandardApplication;
import org.overtime.common.controller.SpringApp;
import org.overtime.configuration.handler.EnableOvertimeHandler;

/**
 * @author ForteScarlet
 */
@EnableOvertimeHandler
@OvertimeStandardApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApp.runStandardController(args);
    }
}
