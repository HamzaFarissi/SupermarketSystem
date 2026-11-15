/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import algorithms.BinarySearch;
import algorithms.MergeSort;
import datastructure.EmployeeBinaryTree;
import java.util.List;
import java.util.Scanner;
import model.Employee;
import service.FileReaderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Supermarket System ===");
        
        List<Employee> employees = FileReaderService.readEmployees("Applicants_Form.txt");
        
        if (employees.isEmpty()) {
            System.out.println("No employees found. Check the file path/name.");
            return;
        }

        // 1. Sort and Display
        MergeSort.sort(employees);
        System.out.println("\n--- First 20 employees sorted alphabetically ---");
        int limit = Math.min(20, employees.size());
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getDetails());
        }

        // 2. Search
        System.out.println("\n=== Testing Binary Search ===");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a full name to search (e.g., John Smith): ");
        String targetName = scanner.nextLine();

        Employee found = BinarySearch.search(employees, targetName);
        if (found != null) {
            System.out.println("-> Found: " + found.getDetails());
        } else {
            System.out.println("-> Employee not found.");
        }

        // 3. Build Binary Tree
        System.out.println("\n=== Building Employee Hierarchy Tree ===");
        EmployeeBinaryTree tree = new EmployeeBinaryTree();
        
        // Insert employees into the tree (minimum 20)
        for (int i = 0; i < limit; i++) {
            tree.insert(employees.get(i));
        }

        System.out.println("\n--- Tree Hierarchy (Level-Order) ---");
        tree.displayLevelOrder();

        System.out.println("\n--- Tree Statistics ---");
        System.out.println("Total Nodes: " + tree.getTotalNodes());
        System.out.println("Tree Height: " + tree.getHeight());
        
        scanner.close();
    }
}