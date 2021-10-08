package org.overtime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author ForteScarlet
 */
@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public Flux<User> getUsers() {
        return Flux.just(
                new User(18, "forte"),
                new User(17, "forli")
        );
    }

}


record User(int age, String name) {
}