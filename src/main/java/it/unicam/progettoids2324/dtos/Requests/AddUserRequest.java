package it.unicam.progettoids2324.dtos.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddUserRequest (
        @NotNull(message = "Email cannot be null")
        @Email(message = "Email not valid")
        String Email,
        @NotNull(message = "Password cannot be null")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
                message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character and be at least 8 characters long"
        )
        String Password
)
{
}
