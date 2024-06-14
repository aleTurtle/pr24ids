package it.unicam.progettoids2324.dtos.Requests;

import it.unicam.progettoids2324.entities.UserRole;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRoleRequest(
        long toUpdateUserId,
        String role
) {}