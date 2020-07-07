package com.juntaek.planeeapi;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Component
public class ApplicationConfiguration {

    @Bean
    ApplicationRunner runner(EmployeeRepository employeeRepository, DatabaseClient db) {

        return args -> {
            DatabaseClient.GenericExecuteSpec initDb = db.execute(
                    "CREATE TABLE employee (" +
                            "id SERIAL PRIMARY KEY," +
                            "first_name VARCHAR(255) NOT NULL," +
                            "last_name VARCHAR(255) NOT NULL)"
            );

            Stream<Employee> stream = Stream.of(new Employee(null, "Petros", "S"));

            Flux<Employee> saveAll = employeeRepository.saveAll(Flux.fromStream(stream));

            initDb // initialize the database
                    .then()
                    .thenMany(saveAll) // then save our Sample Employees
                    .subscribe(); // execute
        };
    }
}

