package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.entity.Employee;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class WordExportService {
    @Autowired
    private EmployeeService employeeService;

    public byte[] generateEmployeeWordDocument() throws IOException {
        List<Employee> employees = employeeService.getAllEmployees();

        XWPFDocument document = new XWPFDocument();

        XWPFParagraph titleParagraph = document.createParagraph();
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText("Empoyee List");
        titleRun.setBold(true);
        titleRun.setFontSize(20);

        for (Employee employee : employees) {
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("ID: " + employee.getId());
            run.addBreak();
            run.setText("Name: " + employee.getName());
            run.addBreak();
            run.setText("Role: " + employee.getRole());
            run.addBreak();
            run.addBreak();
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.write(outputStream);
        document.close();
        return outputStream.toByteArray();

    }

}
