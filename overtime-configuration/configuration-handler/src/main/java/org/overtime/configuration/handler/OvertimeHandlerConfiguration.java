package org.overtime.configuration.handler;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author ForteScarlet
 */
@Slf4j
public class OvertimeHandlerConfiguration implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(
            @NotNull AnnotationMetadata metadata,
            @NotNull BeanDefinitionRegistry registry,
            @NotNull BeanNameGenerator generator
    ) {
        // Guard against calls for sub-classes
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(EnableOvertimeHandler.class.getName());
        if (annotationAttributes == null) {
            return;
        }

        boolean exceptionHandler = (boolean) annotationAttributes.get("exceptionHandler");
        boolean resultHandler = (boolean) annotationAttributes.get("resultHandler");

        log.info("Enable exception handler: {}", exceptionHandler);
        log.info("Enable result handler: {}", resultHandler);

        if (exceptionHandler) {
            BeanDefinitionBuilder overtimeExceptionHandlerDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OvertimeExceptionHandler.class);
            AbstractBeanDefinition overtimeExceptionHandlerDefinition = overtimeExceptionHandlerDefinitionBuilder.getBeanDefinition();
            registry.registerBeanDefinition(generator.generateBeanName(overtimeExceptionHandlerDefinition, registry), overtimeExceptionHandlerDefinition);
        }

        if (resultHandler) {
            BeanDefinitionBuilder overtimeWebfluxConfigurationDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OvertimeWebfluxResultHandlerConfiguration.class);
            AbstractBeanDefinition overtimeWebfluxConfigurationDefinition = overtimeWebfluxConfigurationDefinitionBuilder.getBeanDefinition();
            registry.registerBeanDefinition(generator.generateBeanName(overtimeWebfluxConfigurationDefinition, registry), overtimeWebfluxConfigurationDefinition);

        }

    }
}
