package org.overtime.admin.configuration;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ForteScarlet
 */
@Slf4j
@Configuration
@EnableTransactionManagement
public class TestTranslationManagerConfiguration {


    @Bean
    public TestTranslationManager testTranslationManager(ConnectionFactory connectionFactory) {
        return new TestTranslationManager(connectionFactory);
    }

}

