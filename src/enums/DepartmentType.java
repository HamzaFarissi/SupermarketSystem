/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author DELL
 */
public enum DepartmentType {
    IT_DEVELOPMENT("IT Development"),
    HR("HR"),
    FINANCE("Finance"),
    SALES("Sales"),
    MARKETING("Marketing"),
    CUSTOMER_SERVICE("Customer Service"),
    OPERATIONS("Operations"),
    ACCOUNTING("Accounting"),
    TECHNICAL_SUPPORT("Technical Support");

    private final String displayName;

    DepartmentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static DepartmentType fromString(String text) {
        for (DepartmentType dept : DepartmentType.values()) {
            if (dept.displayName.equalsIgnoreCase(text)) {
                return dept;
            }
        }
        return null;
    }
}