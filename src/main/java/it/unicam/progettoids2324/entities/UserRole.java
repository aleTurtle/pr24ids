package it.unicam.progettoids2324.entities;

public enum  UserRole {
    AUTHENTICATED_TOURIST,
    CONTRIBUTOR,
    AUTHORIZED_CONTRIBUTOR,
    CURATOR,
    ANIMATOR,
    MANAGER;

    public UserRole fromString(String role) {
        return switch (role.toUpperCase()) {
            case "CONTRIBUTOR" -> CONTRIBUTOR;
            case "AUTHORIZED_CONTRIBUTOR" -> AUTHORIZED_CONTRIBUTOR;
            case "CURATOR" -> CURATOR;
            case "ANIMATOR" -> ANIMATOR;
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };
    }
}
