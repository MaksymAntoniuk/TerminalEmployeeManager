package io.github.terminalemployeemanager.util;

import io.github.terminalemployeemanager.entity.InfoEmployee;

import java.util.List;

public class InfoEmployeeFormatter {
    public static void printInfoEmployee(List<InfoEmployee> infoEmployees) {
        if (infoEmployees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.printf("%-5s %-30s %-30s %-15s%n", "ID", "Email", "Phone", "Employee_ID");
        System.out.println("-----------------------------------------------------------------------------------");
        for (InfoEmployee employee : infoEmployees) {
            System.out.printf("%-5d %-30s %-30s %-15s%n", employee.getId(), employee.getEmail(), employee.getPhone(), employee.getEmployee().getId());
        }
    }
}
