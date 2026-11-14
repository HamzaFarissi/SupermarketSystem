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

public class Department {
    private DepartmentType departmentType;

    public Department(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public DepartmentType getDepartmentType() { return departmentType; }

    @Override
    public String toString() { return departmentType.getDisplayName(); }
}