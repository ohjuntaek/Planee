package com.juntaek.planeeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
class MainController {
    @GetMapping("/hello")
    public Mono<String> hey() {
        return Mono.just("hello");
    }
}