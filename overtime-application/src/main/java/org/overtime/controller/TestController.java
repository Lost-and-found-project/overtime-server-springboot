package org.overtime.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.beans.CompensateType;
import org.overtime.repository.TestCompensateTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestCompensateTypeRepository repository;

    @GetMapping("/all")
    public Flux<CompensateType> all() {
        return repository.findAll();
    }

    @GetMapping("/one")
    public Mono<CompensateType> one() {
        return repository.first();
    }

}