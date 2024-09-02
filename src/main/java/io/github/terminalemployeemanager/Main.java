package io.github.terminalemployeemanager;

import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.service.*;
import io.github.terminalemployeemanager.util.EmployeeFormatter;
import io.github.terminalemployeemanager.util.InfoEmployeeFormatter;
import io.github.terminalemployeemanager.util.MenuApp;
import io.github.terminalemployeemanager.util.SalaryFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.github.terminalemployeemanager.repository")
public class Main {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private SalaryService salaryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        Main app = context.getBean(Main.class);
        app.runApplication();
    }

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);

        boolean isAuthenticated = authenticateUser(scanner);

        if (isAuthenticated) {
            runMenu(scanner);
        } else {
            System.out.println("Authentication failed. Exiting the application.");
        }
    }

    private boolean authenticateUser(Scanner scanner) {
        System.out.println("""
                -----------------Welcome to the Terminal Employee Manager-----------------
                Choose an option:
                1. Sign in
                2. Sign up""");
//        System.out.println("Choose an option:");
//        System.out.println("1. Sign in");
//        System.out.println("2. Sign up");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            return signIn(scanner);
        } else if (choice == 2) {
            signUp(scanner);
            return signIn(scanner);  // Allow the user to sign in after signing up
        } else {
            System.out.println("Invalid choice.");
            return false;
        }
    }

    private boolean signIn(Scanner scanner) {
        System.out.println("-----------------Sign in-----------------");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticationService.authenticate(email, password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid email or password.");
            return false;
        }
    }

    private void signUp(Scanner scanner) {
        System.out.println("-----------------Sign up for a new account-----------------");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

       authenticationService.register(email, firstName, lastName, password);
       System.out.println("Sign up successful! Please sign in to continue.");
    }

    private void runMenu(Scanner scanner) {
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
                        findEmployeeById(scanner);
                        break;
                    case 3:
                        addNewEmployee(scanner);
                        break;
                    case 4:
                        deleteEmployee(scanner);
                        break;
                    case 5:
                        addEmployeeInfo(scanner);
                        break;
                    case 6:
                        InfoEmployeeFormatter.printInfoEmployee(infoService.getAll());
                        break;
                    case 7:
                        addSalaryEmployee(scanner);
//                        System.out.print("Enter employee ID: ");
//                        Long id = scanner.nextLong();
//                        System.out.print("Enter employee salary: ");
//                        BigDecimal salary_amount = scanner.nextBigDecimal();
//                        if (salary_amount.compareTo(new BigDecimal(2000)) < 0){
//                            System.out.println("Salary must be equal to or greater than 2000");
//                            break;
//                        }
////                        Optional<Employee> employee = employeeService.getEmployeeById(1L);
//                        if (employeeService.getEmployeeById(id).isPresent()){
//                            salaryService.addSalary(employeeService.getEmployeeById(id).get(), salary_amount);
//                        }
                        break;
                    case 8:
//                        List <Salary> salaryList = salaryService.getAllSalary();
//                        System.out.println(salaryList);
                        SalaryFormater.printSalaryList(salaryService.getAllSalary());
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();  // Clear invalid input
            }
        }
    }

    private void findEmployeeById(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        long id = scanner.nextLong();
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            EmployeeFormatter.printEmployeeList(employee.stream().toList());
        } else {
            System.out.println("Employee not found!");
        }
    }

    private void addNewEmployee(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();
        employeeService.addEmployee(new Employee(name, role));
        System.out.println("Employee successfully added.");
    }

    private void deleteEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        long id = scanner.nextLong();
        employeeService.deleteEmployee(id);
        System.out.println("Employee with ID " + id + " successfully deleted.");
    }

    private void addEmployeeInfo(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter employee email: ");
        String email = scanner.nextLine();

        System.out.print("Enter employee phone: ");
        String phone = scanner.nextLine();

        infoService.addInfoEmployee(id, email, phone);
        System.out.println("Employee information successfully added.");
    }

    private void addSalaryEmployee(Scanner scanner){
        System.out.print("Enter employee ID: ");
        Long id = scanner.nextLong();
        System.out.print("Enter employee salary: ");
        BigDecimal salary_amount = scanner.nextBigDecimal();
        if (salary_amount.compareTo(new BigDecimal(2000)) < 0){
            System.out.println("Salary must be equal to or greater than 2000");
            return;
        }
//                        Optional<Employee> employee = employeeService.getEmployeeById(1L);
        if (employeeService.getEmployeeById(id).isPresent()){
            salaryService.addSalary(employeeService.getEmployeeById(id).get(), salary_amount);
        }
    }

}
