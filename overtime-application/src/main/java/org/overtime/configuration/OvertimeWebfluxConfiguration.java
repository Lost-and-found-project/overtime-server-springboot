package org.overtime.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author ForteScarlet
 */
@Configuration
public class OvertimeWebfluxConfiguration implements WebFluxConfigurer {

    @Bean
    public OvertimeResponseBodyResultHandler overtimeResponseBodyResultHandler(ServerCodecConfigurer serverCodecConfigurer,
                                                                               RequestedContentTypeResolver requestedContentTypeResolver) {

        return new OvertimeResponseBodyResultHandler(serverCodecConfigurer.getWriters(), requestedContentTypeResolver);

    }

}
