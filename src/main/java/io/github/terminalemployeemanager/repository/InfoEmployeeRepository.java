package io.github.terminalemployeemanager.repository;

import io.github.terminalemployeemanager.entity.InfoEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoEmployeeRepository extends JpaRepository<InfoEmployee, Long> {
}
