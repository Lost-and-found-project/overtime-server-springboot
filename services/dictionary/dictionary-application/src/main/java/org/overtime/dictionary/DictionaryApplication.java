package org.overtime.dictionary;

import org.overtime.common.application.OvertimeStandardApplication;
import org.overtime.common.application.SpringApp;

/**
 * Dictionary application.
 *
 * @author ForteScarlet
 */
@OvertimeStandardApplication // Unused yet.
public class DictionaryApplication {
    public static void main(String[] args) {
        SpringApp.runStandardResourcesApi(args);
    }
}
