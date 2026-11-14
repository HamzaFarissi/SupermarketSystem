/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

import java.util.List;
import model.Employee;

public class BinarySearch {

    // Main method to call the recursive search
    public static Employee search(List<Employee> employees, String targetName) {
        if (employees == null || employees.isEmpty()) {
            return null;
        }
        return binarySearch(employees, targetName, 0, employees.size() - 1);
    }

    // Recursive method for Binary Search
    private static Employee binarySearch(List<Employee> employees, String targetName, int left, int right) {
        if (left > right) {
            return null; // Base case: not found
        }

        int mid = left + (right - left) / 2;
        Employee midEmployee = employees.get(mid);
        String midName = midEmployee.getFullName();

        // Check if target is at mid
        int comparison = midName.compareToIgnoreCase(targetName);
        
        if (comparison == 0) {
            return midEmployee; // Found it!
        } else if (comparison > 0) {
            // Target is in the left half
            return binarySearch(employees, targetName, left, mid - 1);
        } else {
            // Target is in the right half
            return binarySearch(employees, targetName, mid + 1, right);
        }
    }
}