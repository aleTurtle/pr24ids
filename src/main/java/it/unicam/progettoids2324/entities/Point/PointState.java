package it.unicam.progettoids2324.entities.Point;

public enum PointState {
    APPROVED,
    NOTAPPROVED,
    PENDING;

    public static PointState fromString(String state) {
        return switch (state) {
            case "APPROVED" -> APPROVED;
            case "NOT APPROVED" -> NOTAPPROVED;
            case "PENDING" -> PENDING;
            default -> throw new IllegalArgumentException("Invalid contest state");
        };
    }
}
