package com.github.marceloleite2604.spring.webflux.repository;

import com.github.marceloleite2604.spring.webflux.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, UUID> {
}
