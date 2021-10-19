package org.overtime.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * @author ForteScarlet
 */
@RestController
public class TestController {

    @GetMapping("/get")
    public Mono<Object> test() {
        return Mono.just(Collections.singletonMap("name", "forte"));
    }

}
