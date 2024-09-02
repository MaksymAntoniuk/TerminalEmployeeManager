package io.github.terminalemployeemanager.repository;

import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
