package org.overtime.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/test")
    public Mono<?> test() {
        return Mono.deferContextual(c -> Flux.fromStream(c.stream().map(e -> e.getKey() + ": " + e.getValue())).collectList());
    }


}
