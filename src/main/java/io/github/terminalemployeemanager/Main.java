package io.github.terminalemployeemanager;

import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.service.EmployeeService;
import io.github.terminalemployeemanager.service.InfoService;
import io.github.terminalemployeemanager.util.EmployeeFormatter;
import io.github.terminalemployeemanager.util.InfoEmployeeFormatter;
import io.github.terminalemployeemanager.util.MenuApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.github.terminalemployeemanager.repository")
public class Main {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InfoService infoService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        Main app = context.getBean(Main.class);
        app.runApplication();
    }

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                MenuApp.showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        EmployeeFormatter.printEmployeeList(employeeService.getAllEmployees());
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Enter employee ID: ");
                        long id = scanner.nextLong();
                        Optional<Employee> employee = employeeService.getEmployeeById(id);
                        if (employee.isPresent()) {
//                            System.out.println(employee.get());
                            EmployeeFormatter.printEmployeeList(employee.stream().toList());
                        } else {
                            System.out.println("Employee not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Role: ");
                        String role = scanner.nextLine();
                        employeeService.addEmployee(new Employee(name, role));
                        System.out.println("Employee successfully added.");
                        break;
                    case 4:
                        System.out.print("Enter employee ID: ");
                        id = scanner.nextLong();
                        employeeService.deleteEmployee(id);
                        System.out.println("Employee with " + id + " successfully deleted.");
                        break;
                    case 5:
                        System.out.print("Enter employee ID: ");
                        id = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Enter employee email: ");
                        String email = scanner.nextLine();

                        System.out.print("Employee phone: ");
                        String phone = scanner.nextLine();

                        infoService.addInfoEmployee(id, email, phone);
                        System.out.println("Employee information successfully added.");
                        break;

                    case 6:
                        InfoEmployeeFormatter.printInfoEmployee(infoService.getAll());
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
