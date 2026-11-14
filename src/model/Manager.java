/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
import enums.ManagerType;

public class Manager extends Person {
    private ManagerType managerType;

    public Manager(String firstName, String lastName, ManagerType managerType) {
        super(firstName, lastName);
        this.managerType = managerType;
    }

    public ManagerType getManagerType() { return managerType; }

    @Override
    public String toString() {
        return getFullName() + " (" + managerType.getDisplayName() + ")";
    }
}