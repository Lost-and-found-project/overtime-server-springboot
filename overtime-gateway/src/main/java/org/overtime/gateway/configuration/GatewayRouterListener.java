package org.overtime.gateway.configuration;

import com.alibaba.nacos.api.config.ConfigChangeEvent;
import com.alibaba.nacos.api.config.ConfigChangeItem;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.client.config.listener.impl.AbstractConfigChangeListener;

import java.util.concurrent.Executor;

/**
 * @author ForteScarlet
 */
class GatewayRouterListener extends AbstractConfigChangeListener {

    @Override
    public void receiveConfigChange(ConfigChangeEvent event) {
        // Nothing.
    }

    @Override
    public void receiveConfigInfo(String configInfo) {
        System.out.println("configInfo = " + configInfo);
    }
}
