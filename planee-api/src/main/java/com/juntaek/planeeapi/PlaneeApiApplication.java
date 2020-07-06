package com.juntaek.planeeapi;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
@EnableR2dbcRepositories
public class PlaneeApiApplication {

    private static final Logger log = LoggerFactory.getLogger(PlaneeApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PlaneeApiApplication.class, args);
        ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        DatabaseClient client = DatabaseClient.create(connectionFactory);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {

        return (args) -> {
            // save a few customers
            repository.saveAll(Arrays.asList(new Customer("Jack", "Bauer"),
                    new Customer("Chloe", "O'Brian"),
                    new Customer("Kim", "Bauer"),
                    new Customer("David", "Palmer"),
                    new Customer("Michelle", "Dessler")))
                    .blockLast(Duration.ofSeconds(10));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().doOnNext(customer -> {
                log.info(customer.toString());
            }).blockLast(Duration.ofSeconds(10));

            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L).doOnNext(customer -> {
                log.info("Customer found with findById(1L):");
                log.info("--------------------------------");
                log.info(customer.toString());
                log.info("");
            }).block(Duration.ofSeconds(10));


            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").doOnNext(bauer -> {
                log.info(bauer.toString());
            }).blockLast(Duration.ofSeconds(10));;
            log.info("");
        };
    }

}