package io.github.terminalemployeemanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees_jpa")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;

    public Employee(){
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, optional = true)
    private InfoEmployee infoEmployee;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
