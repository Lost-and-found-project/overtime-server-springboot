package org.overtime.user;

import org.overtime.common.application.OvertimeStandardApplication;
import org.overtime.common.application.SpringApp;

/**
 * @author ForteScarlet
 */
@OvertimeStandardApplication // Unused yet.
public class UserApplication {
    public static void main(String[] args) {
        SpringApp.runStandardResourcesApi(args);
    }
}
