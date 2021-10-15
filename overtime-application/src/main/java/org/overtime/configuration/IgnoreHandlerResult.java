package org.overtime.configuration;

import java.lang.annotation.*;

/**
 * @author ForteScarlet
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface IgnoreHandlerResult {
}
