package io.github.terminalemployeemanager.util;

public class MenuApp {
    public static void showMenu(){
        System.out.println("""
                    1. List all employees
                    2. Find employee by ID
                    3. Add new employee
                    4. Delete employee
                    5. Exit"""
        );
        System.out.print("Enter your choice: ");
    }
}
