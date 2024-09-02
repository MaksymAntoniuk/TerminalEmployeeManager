package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.entity.Salary;
import io.github.terminalemployeemanager.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;
    @Autowired
    public SalaryService(SalaryRepository salaryRepository){
        this.salaryRepository = salaryRepository;
    }

    public void addSalary(Employee employee, BigDecimal salary_amount){
        salaryRepository.save(new Salary(employee, salary_amount));
    }

    public List<Salary> getAllSalary(){
        return salaryRepository.findAll();
    }
}
