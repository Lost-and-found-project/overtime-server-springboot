package org.overtime.admin;

import org.overtime.common.controller.OvertimeStandardApplication;
import org.overtime.common.controller.SpringApp;

/**
 * @author ForteScarlet
 */
@OvertimeStandardApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApp.runStandardController(args);
    }
}
