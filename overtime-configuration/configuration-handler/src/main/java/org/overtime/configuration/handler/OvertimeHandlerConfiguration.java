package org.overtime.configuration.handler;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ForteScarlet
 */
public class OvertimeHandlerConfiguration implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(
            @NotNull AnnotationMetadata metadata,
            @NotNull BeanDefinitionRegistry registry,
            @NotNull BeanNameGenerator generator
    ) {
        // Guard against calls for sub-classes
        if (metadata.getAnnotationAttributes(EnableOvertimeHandler.class.getName()) == null) {
            return;
        }

        BeanDefinitionBuilder overtimeExceptionHandlerDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OvertimeExceptionHandler.class);
        AbstractBeanDefinition overtimeExceptionHandlerDefinition = overtimeExceptionHandlerDefinitionBuilder.getBeanDefinition();

        BeanDefinitionBuilder overtimeWebfluxConfigurationDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OvertimeWebfluxConfiguration.class);
        AbstractBeanDefinition overtimeWebfluxConfigurationDefinition = overtimeWebfluxConfigurationDefinitionBuilder.getBeanDefinition();


        registry.registerBeanDefinition(generator.generateBeanName(overtimeExceptionHandlerDefinition, registry), overtimeExceptionHandlerDefinition);
        registry.registerBeanDefinition(generator.generateBeanName(overtimeWebfluxConfigurationDefinition, registry), overtimeWebfluxConfigurationDefinition);
    }
}
