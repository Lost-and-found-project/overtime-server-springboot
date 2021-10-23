package org.overtime.configuration.r2dbc;

import org.overtime.common.service.OvertimeR2dbcEntityTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ForteScarlet
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "org.overtime.r2dbc.template")
public class OvertimeR2dbcEntityTemplateConfiguration {


    @Bean
    public OvertimeR2dbcEntityTemplate overtimeR2dbcEntityTemplate(R2dbcEntityTemplate template) {
        return new OvertimeR2dbcEntityTemplate(template);
    }

}
