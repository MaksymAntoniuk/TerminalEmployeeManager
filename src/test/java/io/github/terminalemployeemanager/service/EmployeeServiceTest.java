package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmployeeService(employeeRepository);
    }

    @Test
    void canGetAllEmployees() {
        // when
        underTest.getAllEmployees();
        //then
        verify(employeeRepository).findAll();

    }

    @Test
    void canGetEmployeeById() {
        Employee employee = new Employee("John", "Dev");
        when(employeeRepository.existsById(1L)).thenReturn(true);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Optional<Employee> result = underTest.getEmployeeById(1L);

        assertTrue(result.isPresent());
        assertEquals("John", result.get().getName());
        assertEquals("Dev", result.get().getRole());
        verify(employeeRepository, times(1)).existsById(1L);
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void notCanGetEmployeeById() {
        when(employeeRepository.existsById(1L)).thenReturn(false);

        Optional<Employee> result = underTest.getEmployeeById(1L);

        assertFalse(result.isPresent());
        verify(employeeRepository, times(1)).existsById(1L);
        verify(employeeRepository, times(0)).findById(1L);
    }



    @Test
    void CanAddEmployee() {
        underTest.addEmployee(new Employee());

    }

    @Test
    void deleteEmployee() {
    }
}