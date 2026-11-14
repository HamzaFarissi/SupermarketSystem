/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author DELL
 */
public enum MenuOption {
    SORT(1, "Sort Employee List"),
    SEARCH(2, "Search Employee by Name"),
    ADD_RECORD(3, "Add New Employee"),
    CREATE_TREE(4, "Create Employee Hierarchy Tree"),
    EXIT(5, "Exit");

    private final int code;
    private final String description;

    MenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromCode(int code) {
        for (MenuOption option : MenuOption.values()) {
            if (option.code == code) {
                return option;
            }
        }
        return null;
    }
}