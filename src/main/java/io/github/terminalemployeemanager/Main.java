package io.github.terminalemployeemanager;

import io.github.terminalemployeemanager.model.Employee;
import io.github.terminalemployeemanager.service.EmployeeService;
import io.github.terminalemployeemanager.util.EmployeeFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static io.github.terminalemployeemanager.util.MenuApp.showMenu;
public class Main {
                        public static void main(String[] args) {
                            ApplicationContext context = new AnnotationConfigApplicationContext("io.github.terminalemployeemanager");
                            EmployeeService employeeService = context.getBean(EmployeeService.class);

                            Scanner scanner = new Scanner(System.in);
                            while (true){
                                showMenu();
                                int choice = scanner.nextInt();

                                switch (choice){
                                    case 1:
                                        EmployeeFormatter.printEmployeeList(employeeService.getAllEmployees());
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print("Enter employee ID: ");
                                        long id = scanner.nextLong();
                                        Optional<Employee> employee = employeeService.getEmployeeById(id);
                                        List<Employee> employeeArrayList = new ArrayList<>();
                                        employee.ifPresent(employeeArrayList::add);

                                        if (employee.isPresent()){
                                            EmployeeFormatter.printEmployeeList(employeeArrayList);
                                        } else {
                                            System.out.println("Employee not found!");
                                        }
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.print("Name: ");
                                        String name = scanner.next();
                                        System.out.print("Role: ");
                                        String role = scanner.next();
                                        employeeService.addEmployee(name, role);
                                        System.out.println("Employee with successfully added.");
                                        System.out.println();

                                        break;
                                    case 4:
                                        System.out.print("Enter employee ID: ");
                                        id = scanner.nextInt();
                                        employeeService.deleteEmployee(id);
                                        System.out.println("Employee with " + id + " successfully deleted.");
                                        System.out.println();
                                        break;
                                    case 5:
                                        System.out.println("Exiting...");
                                        scanner.close();
                                        System.exit(0);
                                        break;
                                    default:
                                        System.out.println("Invalid choice, please try again.");
                                }


                            }

                        }
                    }

