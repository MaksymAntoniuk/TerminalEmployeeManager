package io.github.terminalemployeemanager.util;

public class MenuApp {
    public static void showMenu(){
        System.out.println("""
                    1. List of all employees
                    2. Find employee by ID
                    3. Add new employee
                    4. Delete employee
                    5. Add info for employee by ID
                    6. List of all information about employees
                    7. Exit"""
        );
        System.out.print("Enter your choice: ");
    }
}
