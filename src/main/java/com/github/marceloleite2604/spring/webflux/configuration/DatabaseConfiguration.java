package com.github.marceloleite2604.spring.webflux.configuration;

import com.github.marceloleite2604.spring.webflux.model.Employee;
import com.github.marceloleite2604.spring.webflux.repository.EmployeeRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.nio.file.Paths;
import java.util.UUID;

@Configuration
@Slf4j
public class DatabaseConfiguration {

    @Bean
    ConnectionFactoryInitializer createConnectionFactoryInitializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer connectionFactoryInitializer = new ConnectionFactoryInitializer();
        connectionFactoryInitializer.setConnectionFactory(connectionFactory);
        connectionFactoryInitializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource(Paths.get("database", "schema.sql").toString())));

        return connectionFactoryInitializer;
    }

    @Bean
    CommandLineRunner createInitialDataCommandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            log.info("Populating database.");
            employeeRepository.save(
                    Employee.builder()
                            .id(UUID.fromString("ef2826c8-a6a2-4e72-9d70-234f099b4a68"))
                            .name("John Doe")
                            .build());
        };
    }
}
