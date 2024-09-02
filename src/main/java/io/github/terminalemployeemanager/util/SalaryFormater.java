package io.github.terminalemployeemanager.util;

import io.github.terminalemployeemanager.entity.Salary;

import java.util.List;

public class SalaryFormater {
    public static void printSalaryList(List<Salary> salaries){
        System.out.println();
        if (salaries.isEmpty()){
            System.out.println("No salaries data.");
            return;
        }
        System.out.println();

        System.out.println();
        System.out.printf("%-15s %-10s%n", "id_employee", "salary");
        System.out.println("---------------------------------------");

        for (Salary s : salaries){
            System.out.printf("%-15s %-10s%n", s.getEmployee().getId(), s.getSalary());
        }
    }
}
