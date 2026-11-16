/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.DepartmentType;
import enums.ManagerType;
import java.util.Scanner;

public class InputValidator {

    // Validates that the name is not empty
    public static String validateName(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("-> Error: Name cannot be empty. Try again.");
        }
    }

    // Validates that the manager type exists in the Enum
    public static ManagerType validateManagerType(Scanner scanner) {
        while (true) {
            System.out.println("Select Manager Type:");
            System.out.println("1. Head Manager");
            System.out.println("2. Assistant Manager");
            System.out.println("3. Team Lead");
            System.out.print("Choice: ");
            String input = scanner.nextLine().trim();
            
            switch (input) {
                case "1": return ManagerType.HEAD_MANAGER;
                case "2": return ManagerType.ASSISTANT_MANAGER;
                case "3": return ManagerType.TEAM_LEAD;
                default: System.out.println("-> Error: Invalid choice. Try again.");
            }
        }
    }

    // Validates that the department exists in the Enum
    public static DepartmentType validateDepartment(Scanner scanner) {
        while (true) {
            System.out.println("Select Department:");
            DepartmentType[] depts = DepartmentType.values();
            for (int i = 0; i < depts.length; i++) {
                System.out.println((i + 1) + ". " + depts[i].getDisplayName());
            }
            System.out.print("Choice: ");
            String input = scanner.nextLine().trim();
            
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= depts.length) {
                    return depts[choice - 1];
                }
            } catch (NumberFormatException e) {
                // Ignore and loop again
            }
            System.out.println("-> Error: Invalid choice. Try again.");
        }
    }
}