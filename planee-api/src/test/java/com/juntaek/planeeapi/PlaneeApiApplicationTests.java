package com.juntaek.planeeapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebFluxTest
class PlaneeApiApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void contextLoads() {
        webTestClient.get().uri("/hi").exchange()
                .expectStatus().isOk();
    }

}
