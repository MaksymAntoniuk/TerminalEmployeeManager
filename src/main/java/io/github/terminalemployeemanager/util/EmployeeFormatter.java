package io.github.terminalemployeemanager.util;
import io.github.terminalemployeemanager.entity.Employee;
import java.util.List;

public class EmployeeFormatter {
    public static void printEmployeeList(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.printf("%-5s %-20s %-15s%n", "ID", "Name", "Role");
        System.out.println("----------------------------------------");
        for (Employee employee : employees) {
            System.out.printf("%-5d %-20s %-15s%n", employee.getId(), employee.getName(), employee.getRole());
        }
    }
}
