package com.juntaek.planeeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class PlaneeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaneeApiApplication.class, args);
    }

}