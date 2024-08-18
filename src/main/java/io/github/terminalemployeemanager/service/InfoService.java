package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.entity.InfoEmployee;
import io.github.terminalemployeemanager.repository.EmployeeRepository;
import io.github.terminalemployeemanager.repository.InfoEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoService {

    @Autowired
    private InfoEmployeeRepository infoEmployeeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void addInfoEmployee(Long employeeId, String email, String phone) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            InfoEmployee infoEmployee = employee.getInfoEmployee();

            if (infoEmployee == null) {
                infoEmployee = new InfoEmployee();
                infoEmployee.setEmployee(employee);
            }

            infoEmployee.setEmail(email);
            infoEmployee.setPhone(phone);

            infoEmployeeRepository.save(infoEmployee);
        } else {
            throw new IllegalArgumentException("Employee with ID " + employeeId + " not found");
        }
    }

    public List<InfoEmployee> getAll() {
        return infoEmployeeRepository.findAll();
    }
}
