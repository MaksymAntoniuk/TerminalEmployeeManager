package io.github.terminalemployeemanager.controller;

import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import io.github.terminalemployeemanager.entity.Employee;
import io.github.terminalemployeemanager.service.EmployeeService;
import io.github.terminalemployeemanager.service.WordExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WordExportService wordExportService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/export")
    public ResponseEntity<byte[]> exportEmployeesToWords() throws IOException {
        byte[] document = wordExportService.generateEmployeeWordDocument();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "employees.doc");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok().headers(headers).body(document);
    }
}
