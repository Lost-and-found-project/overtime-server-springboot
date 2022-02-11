package org.overtime.admin.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.nio.charset.StandardCharsets;

/**
 * @author ForteScarlet
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Flux<String> test(ServerHttpRequest request) {
        return request.getBody().map(dataBuffer -> dataBuffer.toString(StandardCharsets.UTF_8));
    }

}
