package org.overtime.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.common.Result;
import org.springframework.data.relational.core.sql.In;
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
public class TestController {

    @GetMapping("/get/{num}")
    public Mono<Map<String, Integer>> get(@PathVariable("num") Integer num) {
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

    // private final TestCompensateTypeRepository repository;
    //
    // @GetMapping("/all")
    // public Flux<CompensateType> all() {
    //     return repository.findAll();
    // }
    //
    // @GetMapping("/one")
    // public Mono<CompensateType> one() {
    //     return repository.first();
    // }

}
