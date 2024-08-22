package io.github.terminalemployeemanager.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Long id;

    private String name;
    private String role;

    public Employee(){
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
