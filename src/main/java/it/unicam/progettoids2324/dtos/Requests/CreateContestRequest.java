package it.unicam.progettoids2324.dtos.Requests;

import java.time.LocalDateTime;
public record CreateContestRequest(
        long userId,
        String name,
        String description,
        LocalDateTime start,
        LocalDateTime end,
        String win
) {}
