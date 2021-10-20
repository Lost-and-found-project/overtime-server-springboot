package org.overtime.gateway.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author ForteScarlet
 */
@Component
@ConfigurationProperties(prefix = "overtime.router.nacos")
@Data
public class NacosRouterProperties {
    private String dataId;
    private String group;
}
