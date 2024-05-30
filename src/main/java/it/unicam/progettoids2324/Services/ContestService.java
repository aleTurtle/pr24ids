package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.ContestRepository;
import it.unicam.progettoids2324.Services.Abstractions.ContestServiceInterface;
import it.unicam.progettoids2324.entities.Contest;
import it.unicam.progettoids2324.entities.Municipality;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class ContestService implements ContestServiceInterface {
    private final ContestRepository contestRepository;

    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @Override
    public Contest getContestById(long contestId) {
        return null;
    }

    @Override
    public Set<Contest> getContests(Municipality municipality) {
        if(municipality == null){
            throw new IllegalArgumentException("The municipality cannot be null");
        }
        Set<Contest> contests = new HashSet<>();
        for(Contest c : municipality.getContests()){
            contests.add(c);
        }
        return contests;
    }

    @Override
    public void createContest(String name, String description, LocalDateTime start, LocalDateTime end, String win, Municipality municipality) {
        Contest contest = new Contest(name, description, start, end);
        municipality.addContest(contest);
        this.contestRepository.save(contest);
    }

    @Override
    public void setWinner(long contestId, long userId) {
    }
}
