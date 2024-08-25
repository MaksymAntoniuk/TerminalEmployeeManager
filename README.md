**# Terminal Employee Manager**
A Spring-based console application to manage employee records in a MySQL database. This application allows users to view all employees, find an employee by ID, add new employees, delete employees and 
Add data information about an employee to another table which will contain these data. These features can be depended on from branch, every branch will contain more new features in the future (all descriptions will be in this file).

## Technologies Used
- **Java 17**: Core programming language.
- **Spring Framework**: Used for dependency injection, JDBC template, and application configuration.
- **Spring Boot**: Simplifies the configuration of the Spring application.
- **MySQL**: Database to store employee information.
- **Maven**: Build and dependency management tool.
- **Lombok**: Reduces boilerplate code for Java classes.

# Features for `main` branch
- List all employees
- Find employee by ID
- Add new employee
- Delete employee
- Exit

## Database Setup
- Install and set up MySQL on your local machine.
- Create a database named `employees_spring`.
- Create a table named `employees` with the following schema:

    `CREATE TABLE employees (
          id INT AUTO_INCREMENT PRIMARY KEY,
          name VARCHAR(255),
          role VARCHAR(255)
    );`

- Update your database credentials in the AppConfig.java file:
      `dataSource.setUrl("jdbc:mysql://localhost:3306/employees_spring");
       dataSource.setUsername("your_username");
       dataSource.setPassword("your_password");`
  
## Input('main' branch)
After run of application in the terminal appear:
1. List all employees
2. Find employee by ID
3. Add new employee
4. Delete employee
5. Exit

* Option 1: Lists all employees in the database.
* Option 2: Prompts for an employee ID and displays the corresponding employee's details if found.
* Option 3: Prompts for a name and role, then adds the new employee to the database.
* Option 4: Prompts for an employee ID and deletes the corresponding employee from the database.
* Option 5: Exits the application.

## Example
           1. List all employees
           2. Find employee by ID
           3. Add new employee
           4. Delete employee
           5. Exit
              Enter your choice: 1
              ID    Name                 Role
        ----------------------------------------
        4     Maksym               developer      
        5     Eva                  Designer       
        6     Richard              menager        
        7     Don                  tester
        
           1. List all employees
           2. Find employee by ID
           3. Add new employee
           4. Delete employee
           5. Exit
              Enter your choice: 2
              Enter employee ID: 5
              ID    Name                 Role
        ----------------------------------------
        5     Eva                  Designer
        
           1. List all employees
           2. Find employee by ID
           3. Add new employee
           4. Delete employee
           5. Exit
              Enter your choice: 3
              Name: Bob
              Role: admin
              Employee with successfully added.
        
           1. List all employees
           2. Find employee by ID
           3. Add new employee
           4. Delete employee
           5. Exit
              Enter your choice: 1
              ID    Name                 Role
        ----------------------------------------
        4     Maksym               developer      
        5     Eva                  Designer       
        6     Richard              menager        
        7     Don                  tester         
        11    Bob                  admin
        
           1. List all employees
           2. Find employee by ID
           3. Add new employee
           4. Delete employee
           5. Exit
              Enter your choice: 4
              Enter employee ID: 11
              Employee with 11 successfully deleted.

           1. List all employees
           2. Find employee by ID
           3. Add new employee
           4. Delete employee
           5. Exit
              Enter your choice: 1
              ID    Name                 Role
        ----------------------------------------
        4     Maksym               developer      
        5     Eva                  Designer       
        6     Richard              menager        
        7     Don                  tester
        
           1. List all employees
           2. Find employee by ID
           3. Add new employee
           4. Delete employee
           5. Exit
              Enter your choice: 5
              Exiting...

**# Features for `migrate-to-jpa` branch**
- List of all employees
- Find employee by ID
- Add new employee
- Delete employee
- Add info for employee by ID
- List of all information about employees
- Exit

This branch is similar to 'main' but has new feature and uses another technology to manage a database.
Refactor EmployeeDao to EmployeeRepository using JPA.
A new feature allows users to add employee information to the database and list all-employees information a table.

## Changes
- Replaced the `JdbcTemplate` with a `JpaRepository`.
- Updated all data access methods to use JPA's features instead of direct SQL queries.
- Modified entity mappings in `Employee` to support JPA annotations.
- Update connection to a database by using configuring connection details in `application.properties`

## Setup `application.properties` for connection to a database
    spring.datasource.url= link_to_database(example: jdbc:mysql://localhost:3306/name_database)
    spring.datasource.username=username_databse
    spring.datasource.password=password_database

## Add new table to a database 
All database tables are now automatically generated using JPA annotations,
with each table's structure defined in the entity package.

## Input(`migrate-to-jpa` branch)
After running the application in the terminal:
1. List all employees
2. Find employee by ID
3. Add new employee
4. Delete employee
5. Add info for employee by ID
6. List of all information about employees
7. Exit

* Option 1: Lists all employees in the database.
* Option 2: Prompts for an employee ID and displays the corresponding employee's details if found.
* Option 3: Prompts for a name and role, then adds the new employee to the database.
* Option 4: Prompts for an employee ID and deletes the corresponding employee from the database.
* Option 5: Prompts for an employee ID and allows the user to add additional information (email and phone) to the employee record.
* Option 6: Lists all available information about employees in the database.
* Option 7: Exits the application.

## Example
       1. List all employees
       2. Find employee by ID
       3. Add new employee
       4. Delete employee
       5. Add info for employee by ID
       6. List of all information about employees
       7. Exit
          Enter your choice: 1
    
    ID    Name       Role
    --------------------------
    4     Maksym     developer      
    5     Eva        Designer       
    6     Richard    Manager        
    7     Don        Tester
    
       1. List all employees
       2. Find employee by ID
       3. Add new employee
       4. Delete employee
       5. Add info for employee by ID
       6. List of all information about employees
       7. Exit
          Enter your choice: 2
          Enter employee ID: 5
    
    ID    Name       Role
    --------------------------
    5     Eva        Designer
    
       1. List all employees
       2. Find employee by ID
       3. Add new employee
       4. Delete employee
       5. Add info for employee by ID
       6. List of all information about employees
       7. Exit
          Enter your choice: 3
          Name: Bob
          Role: Admin
          Employee successfully added.
    
       1. List all employees
       2. Find employee by ID
       3. Add new employee
       4. Delete employee
       5. Add info for employee by ID
       6. List of all information about employees
       7. Exit
          Enter your choice: 1
    
    ID    Name       Role
    --------------------------
    4     Maksym     developer      
    5     Eva        Designer       
    6     Richard    Manager        
    7     Don        Tester         
    11    Bob        Admin
    
       1. List all employees
       2. Find employee by ID
       3. Add new employee
       4. Delete employee
       5. Add info for employee by ID
       6. List of all information about employees
       7. Exit
          Enter your choice: 4
          Enter employee ID: 11
          Employee with ID 11 successfully deleted.
    
       1. List all employees
       2. Find employee by ID
       3. Add new employee
       4. Delete employee
       5. Add info for employee by ID
       6. List of all information about employees
       7. Exit
          Enter your choice: 1
    
    ID    Name       Role
    --------------------------
    4     Maksym     developer      
    5     Eva        Designer       
    6     Richard    Manager        
    7     Don        Tester
    
       1. List all employees
       2. Find employee by ID
       3. Add new employee
       4. Delete employee
       5. Add info for employee by ID
       6. List of all information about employees
       7. Exit
          Enter your choice: 5
          Exiting...

**# Features for `new-feature-write-data-to-document` branch**
This version implements a new feature that uses REST API endpoints defined in the controller package. Users can now
download a Word document containing all employee data from the database, can get JSON with data from a database for employee by ID.

## Setup `application.properties` for connection to a database
    spring.datasource.url= link_to_database(example: jdbc:mysql://localhost:3306/name_database)
    spring.datasource.username=username_databse
    spring.datasource.password=password_database


## How to download Word with data
You need to have Web Browser and then in the search fields you need to write
        `http://localhost:number_port(8080)/api/employee/export`

Spring in default settings always use port 8080.
Can be a problem with `server.port` it can be busy by another application then you need
to change number port in `application.properties`.
        `server.port=number_port`

## To get JSON for employee by ID
In the search fields of Web Browser you need to write
        `http://localhost:number_port(8080)/api/employee/id_employee`
Spring in default settings always use port 8080.
Can be a problem with `server.port` it can be busy by another application then you need
to change number port in `application.properties`.
`server.port=number_port` 

## Example for get JSON
Input in the fields of Web Browser

    `http://localhost:8080/api/employee/4`

Output
    `{"id":3,"name":"Joshua","role":"Administrator"}
`

## Example for download 
Input in the fields of Web Browser

    `http://localhost:8080/api/employee/export`

Output in the Word Document

        `Empoyee List
        ID: 1
        Name: Maksym
        Role: Java Dev
        
        
        ID: 3
        Name: Joshua
        Role: Administrator`
