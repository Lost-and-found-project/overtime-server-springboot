package org.overtime.admin.configuration;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ForteScarlet
 */
@Configuration
public class TestTranslationManagerConfiguration {

    @Bean
    public TestTranslationManager testTranslationManagerConfiguration(ConnectionFactory connectionFactory) {
        return new TestTranslationManager(connectionFactory);
    }

}
