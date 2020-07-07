package com.juntaek.planeeapi;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

    @Query("select e.* from Employee e where e.last_name = :lastName")
    Mono<Employee> findEmployeeByLastName(String lastName);
}
