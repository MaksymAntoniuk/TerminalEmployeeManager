package io.github.terminalemployeemanager.config;

import io.github.terminalemployeemanager.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EmployeeConfig {

    @Bean
    public Employee employee() {
        return new Employee();
    }
}
