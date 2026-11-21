/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import enums.DepartmentType;
import enums.ManagerType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class FileReaderService {

    public static List<Employee> readEmployees(String filename) {
        List<Employee> employees = new ArrayList<>();
        String line;
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue; // Skip header
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",", -1);
                if (parts.length < 9) {
                    System.err.println("Skipping invalid employee record at line " + lineNumber
                            + ": expected 9 columns, found " + parts.length + ".");
                    continue;
                }

                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                String email = parts[3].trim();
                double salary;
                try {
                    salary = Double.parseDouble(parts[4].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid employee record at line " + lineNumber
                            + ": salary is not a number.");
                    continue;
                }
                String deptRaw = parts[5].trim();
                String position = parts[6].trim();
                String jobTitle = parts[7].trim();

                DepartmentType dept = DepartmentType.fromString(deptRaw);
                if (dept == null) dept = DepartmentType.OPERATIONS;

                ManagerType mgr = mapToManagerType(position, jobTitle);

                employees.add(new Employee(firstName, lastName, mgr, dept, email, salary));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("[INFO] Loaded " + employees.size() + " employees.");
        return employees;
    }

    private static ManagerType mapToManagerType(String position, String jobTitle) {
        String combined = (position + " " + jobTitle).toLowerCase();
        if (combined.contains("head managenagerr")) return ManagerType.HEAD_MANAGER;
        if (combined.contains("senior manager")) return ManagerType.ASSISTANT_MANAGER;
        if (combined.contains("manager")) return ManagerType.ASSISTANT_MANAGER;
        if (combined.contains("team lead")) return ManagerType.TEAM_LEAD;
        return ManagerType.TEAM_LEAD;
    }
}