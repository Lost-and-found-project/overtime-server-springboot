package org.overtime.gateway.controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ForteScarlet
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${username:no}")
    @Setter
    private String name;

    @GetMapping("/test/get")
    public String get() {
        return name;
    }

}
