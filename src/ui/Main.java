/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import algorithms.MergeSort;
import java.util.List;
import model.Employee;
import service.FileReaderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing File Reader & Merge Sort ===");
        
        List<Employee> employees = FileReaderService.readEmployees("Applicants_Form.txt");
        
        if (employees.isEmpty()) {
            System.out.println("No employees found. Check the file path/name.");
            return;
        }

        // 1. Sort the list of employees
        MergeSort.sort(employees);
        System.out.println("Sorted successfully!\n");

        // 2. Display the first 20 employees (as requested in the assignment)
        System.out.println("--- First 20 employees sorted alphabetically ---");
        int limit = Math.min(20, employees.size());
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getDetails());
        }
    }
}