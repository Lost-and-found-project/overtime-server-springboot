package org.overtime.configuration.r2dbc;

import org.overtime.common.service.OvertimeR2dbcEntityTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

/**
 * Config for {@link OvertimeR2dbcEntityTemplate}
 *
 * @author ForteScarlet
 */
@Configuration(proxyBeanMethods = false)
public class OvertimeR2dbcEntityTemplateConfiguration {

    @Bean
    public OvertimeR2dbcEntityTemplate overtimeR2dbcEntityTemplate(R2dbcEntityTemplate template) {
        return new OvertimeR2dbcEntityTemplate(template);
    }

}
