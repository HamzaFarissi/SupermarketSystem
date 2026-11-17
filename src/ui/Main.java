package ui;

import algorithms.BinarySearch;
import algorithms.MergeSort;
import datastructure.EmployeeBinaryTree;
import enums.DepartmentType;
import enums.ManagerType;
import enums.MenuOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Employee;
import service.FileReaderService;
import service.InputValidator;

public class Main {

    private static final String DEFAULT_FILENAME = "Applicants_Form.txt";
    private static final int MINIMUM_TREE_RECORDS = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the filename to read (press Enter for "
                + DEFAULT_FILENAME + "): ");
        String filename = scanner.nextLine().trim();
        if (filename.isEmpty()) {
            filename = DEFAULT_FILENAME;
        }

        List<Employee> employees = FileReaderService.readEmployees(filename);
        List<Employee> addedEmployees = new ArrayList<>();

        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Select an option: ");
            String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Enter a number from the menu.");
                continue;
            }

            MenuOption option = MenuOption.fromCode(choice);
            if (option == null) {
                System.out.println("Invalid choice. Enter a number from the menu.");
                continue;
            }

            switch (option) {
                case SORT:
                    sortAndDisplayEmployees(employees);
                    break;
                case SEARCH:
                    searchEmployees(scanner, employees);
                    break;
                case ADD_RECORD:
                    addEmployee(scanner, employees, addedEmployees);
                    break;
                case CREATE_TREE:
                    createEmployeeTree(employees);
                    break;
                case EXIT:
                    System.out.println("Exiting Supermarket System.");
                    running = false;
                    break;
                default:
                    throw new IllegalStateException("Unhandled menu option: " + option);
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Supermarket System ===");
        System.out.println("Please select an option:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getCode() + ". " + option.getDescription());
        }
    }

    private static void sortAndDisplayEmployees(List<Employee> employees) {
        MergeSort.sort(employees);
        System.out.println("\n--- First 20 employees sorted alphabetically ---");
        displayFirstTwenty(employees);
    }

    private static void displayFirstTwenty(List<Employee> employees) {
        int limit = Math.min(20, employees.size());
        if (limit == 0) {
            System.out.println("No employee records are available.");
            return;
        }

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getDetails());
        }
    }

    private static void searchEmployees(Scanner scanner, List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employee records are available to search.");
            return;
        }

        MergeSort.sort(employees);
        String targetName = InputValidator.validateName(scanner, "Enter a full name to search: ");
        Employee found = BinarySearch.search(employees, targetName);
        if (found != null) {
            System.out.println("Found: " + found.getDetails());
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void addEmployee(Scanner scanner, List<Employee> employees,
            List<Employee> addedEmployees) {
        String[] nameParts;
        while (true) {
            String fullName = InputValidator.validateName(scanner, "Please input the employee name: ");
            nameParts = fullName.trim().split("\\s+", 2);
            if (nameParts.length == 2) {
                break;
            }
            System.out.println("Please enter both a first and last name.");
        }

        System.out.println("Please select the Manager Type:");
        ManagerType managerType = InputValidator.validateManagerType(scanner);
        System.out.println("Please select the Department:");
        DepartmentType department = InputValidator.validateDepartment(scanner);

        Employee employee = new Employee(nameParts[0], nameParts[1], managerType, department);
        employees.add(employee);
        addedEmployees.add(employee);
        MergeSort.sort(employees);

        System.out.println("\"" + employee.getFullName() + "\" has been added as \""
                + managerType.getDisplayName() + "\" to \""
                + department.getDisplayName() + "\" successfully!");
        System.out.println("\n--- Newly added employee records ---");
        for (Employee addedEmployee : addedEmployees) {
            System.out.println(addedEmployee.getDetails());
        }
    }

    private static void createEmployeeTree(List<Employee> employees) {
        if (employees.size() < MINIMUM_TREE_RECORDS) {
            System.out.println("At least " + MINIMUM_TREE_RECORDS
                    + " employee records are required to create the hierarchy. "
                    + "Currently available: " + employees.size() + ".");
            return;
        }

        EmployeeBinaryTree tree = new EmployeeBinaryTree();
        for (Employee employee : employees) {
            tree.insert(employee);
        }

        System.out.println("\n--- Employee Hierarchy (Level-Order) ---");
        tree.displayLevelOrder();
        System.out.println("\n--- Tree Statistics ---");
        System.out.println("Total Nodes: " + tree.getTotalNodes());
        System.out.println("Tree Height: " + tree.getHeight());
    }
}
