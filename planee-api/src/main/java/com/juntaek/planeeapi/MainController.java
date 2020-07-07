package com.juntaek.planeeapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
class MainController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/")
    public Flux<Employee> hey() {

        return employeeRepository.findAll();
    }
}