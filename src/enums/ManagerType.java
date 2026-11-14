/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author DELL
 */
public enum ManagerType {
    HEAD_MANAGER("Head Manager"),
    ASSISTANT_MANAGER("Assistant Manager"),
    TEAM_LEAD("Team Lead");

    private final String displayName;

    ManagerType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ManagerType fromString(String text) {
        for (ManagerType type : ManagerType.values()) {
            if (type.displayName.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }
}
