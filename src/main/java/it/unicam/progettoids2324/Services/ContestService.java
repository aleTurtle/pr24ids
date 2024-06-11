package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.ContestRepository;
import it.unicam.progettoids2324.Services.Abstractions.ContestServiceInterface;
import it.unicam.progettoids2324.entities.Contest;
import it.unicam.progettoids2324.entities.ContestState;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class ContestService implements ContestServiceInterface {
    private final ContestRepository contestRepository;
    private final UserService userService;
    private UserService Userservice;

    public ContestService(ContestRepository contestRepository,UserService userService ) {
        this.contestRepository = contestRepository;

        this.userService =  userService;
    }

    @Override
    public Contest getContestById(long contestId) {
        return this.contestRepository.findById(contestId).orElseThrow();
    }


    public Set<Contest> getContests(long userId) {

        this.checkRole(this.Userservice.getUserById(userId).getRole());

        Set<Contest> contests = new HashSet<>();
        for(Contest c : this.contestRepository.findAll()){
            contests.add(c);
        }
        return contests;
    }

    @Override
    public void createContest(long userId, String name, String description, LocalDateTime start, LocalDateTime end, String win) {

        if (this.Userservice.getUserById(userId).getRole() != UserRole.ANIMATOR) {
            throw new IllegalArgumentException("User not authorized to create a contest");
        }

        Contest contest = new Contest(name, description, start, end);
        this.contestRepository.save(contest);
    }

    @Override
    public void setWinner(long contestId, long userId) {
    }

    private void checkRole(UserRole role) {
        if (role != UserRole.ANIMATOR) {
            throw new IllegalArgumentException("The user is not authorized to create a contest");
        }
    }
    @Override
    public void openContest(long userId, long contestId) {

        this.checkRole(this.Userservice.getUserById(userId).getRole());

        Contest contest = this.getContestById(contestId);

        if (contest.getState() != ContestState.CREATED) {
            throw new IllegalArgumentException("The contest is already open or closed");
        }
        contest.setState(ContestState.OPEN);
        this.contestRepository.save(contest);
    }

    @Override
    public void closeContest(long userId, long contestId) {

        this.checkRole(this.Userservice.getUserById(userId).getRole());

        Contest contest = this.getContestById(contestId);

        if (contest.getState() != ContestState.OPEN) {
            throw new IllegalArgumentException("The contest is not open or already closed");
        }
        contest.setState(ContestState.CLOSED);

        this.contestRepository.save(contest);
    }



}