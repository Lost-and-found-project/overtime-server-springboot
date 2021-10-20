package org.overtime.gateway.configuration;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author ForteScarlet
 */
// @Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NacosRouterConfiguration implements ApplicationRunner {
    private final NacosConfigManager manager;
    private final NacosRouterProperties nacosRouterProperties;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ConfigService configService = manager.getConfigService();
        configService.addListener(
                nacosRouterProperties.getDataId(),
                nacosRouterProperties.getGroup(),
                new GatewayRouterListener()
        );
    }


}
