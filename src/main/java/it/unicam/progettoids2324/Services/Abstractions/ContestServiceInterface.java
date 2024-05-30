package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.Contest;
import it.unicam.progettoids2324.entities.Municipality;

import java.time.LocalDateTime;
import java.util.Set;

public interface ContestServiceInterface {

    /**
     * Return the contest by the id
     * @param contestId
     * @return Contest with the id
     */
    Contest getContestById(long contestId);

    Set<Contest> getContests(Municipality municipality);

    /**
     * Create a contest
     * @param name
     * @param description
     * @param start
     * @param end
     * @param win
     * @throws IllegalArgumentException
     */
    void createContest(String name, String description, LocalDateTime start, LocalDateTime end, String win, Municipality municipality);

    /**
     * Set the winner from the id
     * @param contestId
     * @param userId
     */
    void setWinner(long contestId, long userId);


}
