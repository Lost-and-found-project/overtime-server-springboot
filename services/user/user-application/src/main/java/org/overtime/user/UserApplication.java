package org.overtime.user;

import org.overtime.common.controller.OvertimeStandardApplication;
import org.overtime.common.controller.SpringApp;
import org.overtime.common.controller.StandardResourceApiApplication;
import org.springframework.boot.SpringApplication;

/**
 * @author ForteScarlet
 */
@OvertimeStandardApplication // Unused yet.
public class UserApplication {
    public static void main(String[] args) {
        SpringApp.runStandardResourcesApi(args);
    }
}
