/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class MergeSort {

    // Main method to sort the list of employees
    public static void sort(List<Employee> employees) {
        if (employees == null || employees.size() <= 1) {
            return;
        }
        List<Employee> sortedList = mergeSort(employees);
        
        // Copy the sorted data back to the original list
        for (int i = 0; i < employees.size(); i++) {
            employees.set(i, sortedList.get(i));
        }
    }

    // Recursive method to divide the list
    private static List<Employee> mergeSort(List<Employee> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        
        // Divide the list into two halves
        List<Employee> left = new ArrayList<>(list.subList(0, mid));
        List<Employee> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Method to merge two sorted lists
    private static List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();
        int i = 0, j = 0;

        // Compare elements and add the smaller one to the result list
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getFullName().compareToIgnoreCase(right.get(j).getFullName()) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Add any remaining elements from the left list
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        
        // Add any remaining elements from the right list
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}