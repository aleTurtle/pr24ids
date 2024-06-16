package it.unicam.progettoids2324.dtos.Requests;

import it.unicam.progettoids2324.entities.User;

import java.time.LocalDateTime;
public record CreateContestRequest(
        long userId,
        String name,
        String description,
        LocalDateTime start,
        LocalDateTime end,
        long winnerId
) {}
