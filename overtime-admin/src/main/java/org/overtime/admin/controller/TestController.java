package org.overtime.admin.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.user.api.UserApi;
import org.overtime.user.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/test")
public class TestController {

    private final UserApi userApi;

    @GetMapping("/isAdmin/{id}")
    public Mono<?> test(@PathVariable long id) {
        return userApi.findUserById(id).map(User::isAdmin).defaultIfEmpty(false);
    }


}
