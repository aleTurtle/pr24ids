package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.Contest;


import java.time.LocalDateTime;
import java.util.Set;

public interface ContestServiceInterface {

    Contest getContestById(long contestId);

    Set<Contest> getContests(long userId);
    void createContest(long userId, String name, String description, LocalDateTime start, LocalDateTime end, long winnerId);

    void setWinner(long contestId, long userId);

    void openContest(long userId, long contestId);

    void closeContest(long userId, long contestId);
    //  Set<ContentDTO> getContestContributions(long userId, long contestId);

}