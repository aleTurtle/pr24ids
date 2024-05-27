package it.unicam.progettoids2324.dtos;

import java.time.LocalDateTime;

public record ContestDTO(String name, String description, LocalDateTime start, LocalDateTime end, String win) { }
