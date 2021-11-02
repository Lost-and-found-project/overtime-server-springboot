package org.overtime.configuration.handler;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ForteScarlet
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(OvertimeHandlerConfiguration.class)
public @interface EnableOvertimeHandler {
    boolean exceptionHandler() default true;

    boolean resultHandler() default true;
}
