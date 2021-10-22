package org.overtime.configuration.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * 注册 {@link OvertimeResponseBodyResultHandler} 响应值处理器。
 * @author ForteScarlet
 */
@Configuration
public class OvertimeWebfluxResultHandlerConfiguration implements WebFluxConfigurer {

    @Bean
    public OvertimeResponseBodyResultHandler overtimeResponseBodyResultHandler(ServerCodecConfigurer serverCodecConfigurer,
                                                                               RequestedContentTypeResolver requestedContentTypeResolver) {

        System.out.println("Handler get!");

        return new OvertimeResponseBodyResultHandler(serverCodecConfigurer.getWriters(), requestedContentTypeResolver);
    }

}
