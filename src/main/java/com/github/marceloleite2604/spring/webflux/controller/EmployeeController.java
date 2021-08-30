package com.github.marceloleite2604.spring.webflux.controller;

import com.github.marceloleite2604.spring.webflux.model.Employee;
import com.github.marceloleite2604.spring.webflux.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeById(@PathVariable UUID id) {
        return employeeRepository.findById(id);
    }

    @GetMapping
    private Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
