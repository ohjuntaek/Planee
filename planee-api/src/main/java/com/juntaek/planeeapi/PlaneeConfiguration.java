package com.juntaek.planeeapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
@EnableWebFlux
public class PlaneeConfiguration {
    @Bean
    public RouterFunction<ServerResponse> routes(PlaneeFunctionHandler handler) {
        return RouterFunctions.route(GET("/hi"), handler::hello);
    }
}


