package org.overtime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

/**
 * @author ForteScarlet
 */
@RestController
@RequiredArgsConstructor
public class TestOvSController {

    @GetMapping("/get/{num}")
    public Mono<Map<String, Integer>> get(@PathVariable("num") Integer num, ServerHttpRequest request) {
        System.out.println(request);
        if (num == 0) {
            throw new IllegalArgumentException("不能是0! ");
        }
        return Mono.just(Collections.singletonMap("number", num));
    }


    @GetMapping("/got/{num}")
    public Integer got(@PathVariable("num") Integer num) {
        if (num == 0) {
            throw new IllegalArgumentException("不能是1! ");
        }
        return num;
    }


    
}
