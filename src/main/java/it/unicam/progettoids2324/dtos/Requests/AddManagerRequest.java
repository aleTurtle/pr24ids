package it.unicam.progettoids2324.dtos.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AddManagerRequest(

        @NotNull(message = "Email cannot be null")
        @Email(message = "Email not valid")
        String Email,
        @NotNull(message = "Password cannot be null")
        String password

) {
}
