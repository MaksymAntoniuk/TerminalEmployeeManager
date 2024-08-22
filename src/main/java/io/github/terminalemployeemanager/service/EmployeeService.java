package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.model.Employee;
import io.github.terminalemployeemanager.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeDao.findById(id);
    }

    public int addEmployee(String name, String role){
        return employeeDao.addEmployee(name, role);
    }
    public int deleteEmployee(Long id){
        return employeeDao.deleteEmployee(id);
    }


}
