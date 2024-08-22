package io.github.terminalemployeemanager;

import io.github.terminalemployeemanager.model.Employee;
import io.github.terminalemployeemanager.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
                                        employeeService.getAllEmployees().forEach(System.out::println);
                                        break;
                                    case 2:
                                        System.out.print("Enter employee ID: ");
                                        int id = scanner.nextInt();
                                        Optional<Employee> employee = employeeService.getEmployeeById(id);
                                        if (employee != null){
                                            System.out.println(employee);
                                        } else {
                                            System.out.println("Employee not found!");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Name: ");
                                        String name = scanner.next().toString();
                                        System.out.print("Role: ");
                                        String role = scanner.next().toString();
                                        Employee employee1 = new Employee(name, role);
                                        employeeService.addEmployee(employee1);
                                        break;
                                    case 4:
                                        System.out.println("Enter employee ID: ");
                                        id = scanner.nextInt();
                                        employeeService.deleteEmployee(id);
                                        System.out.println("Employee with " + id + " successfully deleted.");
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
                    
                default:
                    System.out.println("Invalid choice, please try again.");
            }


        }

    }
}
