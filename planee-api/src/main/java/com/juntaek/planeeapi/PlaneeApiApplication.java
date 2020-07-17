package com.juntaek.planeeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PlaneeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaneeApiApplication.class, args);
    }

}