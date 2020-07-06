package com.juntaek.planeeapi;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PlaneeFunctionHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("hello"), String.class);
    }
}
