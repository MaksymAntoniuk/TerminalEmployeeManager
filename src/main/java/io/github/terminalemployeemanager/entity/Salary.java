package io.github.terminalemployeemanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "salary")
@Getter
@Setter
@NoArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    private BigDecimal salary;

    @PrePersist
    @PreUpdate
    private void validateSalary(){
        if (salary.compareTo(BigDecimal.valueOf(2000)) < 0){
            throw new IllegalArgumentException("Salary must be at least 2000");
        }
    }

    public Salary(Employee employee, BigDecimal salary) {
        this.employee = employee;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", employee=" + employee.getId() +
                ", salary=" + salary +
                '}';
    }
}
