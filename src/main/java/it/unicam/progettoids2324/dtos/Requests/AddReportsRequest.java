package it.unicam.progettoids2324.dtos.Requests;

import jakarta.validation.constraints.NotEmpty;


public record AddReportsRequest(
        @NotEmpty(message = "Description cannot be empty")
        String description
)
{
}
