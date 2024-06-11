package it.unicam.progettoids2324.dtos.Requests;

import it.unicam.progettoids2324.entities.UserRole;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRole(
        @NotNull(message = "user is empty")
        long userId,
        @NotNull(message = "role is empty")
        String role
) {
    public UpdateUserRole {
        // Verifica se il ruolo fornito è valido
        if (!isValidRole(role)) {
            throw new IllegalArgumentException("Ruolo non valido: " + role);
        }
    }

    // Metodo per verificare se un ruolo è valido
    private static boolean isValidRole(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
}
