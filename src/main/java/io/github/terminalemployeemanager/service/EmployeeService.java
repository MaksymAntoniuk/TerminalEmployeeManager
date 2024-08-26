package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        if (employeeRepository.existsById(id)) {
            return employeeRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }



}
