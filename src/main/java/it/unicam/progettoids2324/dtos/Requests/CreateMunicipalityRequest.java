package it.unicam.progettoids2324.dtos.Requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateMunicipalityRequest(
        @NotNull(message = "Name cannot be null")
        @NotEmpty(message = "Name cannot be empty")
        String name,
        @NotNull(message = "Province cannot be null")
        @NotEmpty(message = "Province cannot be empty")
        String province
)
{}
