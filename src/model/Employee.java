/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
import enums.DepartmentType;
import enums.ManagerType;

public class Employee extends Person {
    private ManagerType managerType;
    private DepartmentType department;
    private String email;
    private double salary;

    public Employee(String firstName, String lastName, ManagerType managerType, DepartmentType department) {
        super(firstName, lastName);
        this.managerType = managerType;
        this.department = department;
    }

    public Employee(String firstName, String lastName, ManagerType managerType, DepartmentType department, String email, double salary) {
        this(firstName, lastName, managerType, department);
        this.email = email;
        this.salary = salary;
    }

    public ManagerType getManagerType() { return managerType; }
    public DepartmentType getDepartment() { return department; }
    public String getEmail() { return email; }
    public double getSalary() { return salary; }

    public String getDetails() {
        return String.format("%-20s | %-18s | %-18s", getFullName(), managerType.getDisplayName(), department.getDisplayName());
    }

    @Override
    public String toString() { return getDetails(); }
}
