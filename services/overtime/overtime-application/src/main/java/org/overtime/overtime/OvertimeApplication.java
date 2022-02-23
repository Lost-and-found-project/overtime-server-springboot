package org.overtime.overtime;

import org.overtime.common.application.OvertimeStandardApplication;
import org.overtime.common.application.SpringApp;

/**
 * @author ForteScarlet
 */
@OvertimeStandardApplication
public class OvertimeApplication {
    public static void main(String[] args) {
        SpringApp.runStandardResourcesApi(args);
    }
}
