/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.List;
import model.Employee;
import service.FileReaderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing File Reader ===");
        
        List<Employee> employees = FileReaderService.readEmployees("Applicants_Form.txt");
        
        if (employees.isEmpty()) {
            System.out.println("No employees found. Check the file path/name.");
            return;
        }

        System.out.println("\nFirst 5 employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }
}