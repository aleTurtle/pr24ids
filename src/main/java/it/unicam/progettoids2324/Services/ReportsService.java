package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.ReportRepository;
import it.unicam.progettoids2324.Services.Abstractions.ReportsServiceInterface;
import it.unicam.progettoids2324.dtos.ReportsDTO;
import it.unicam.progettoids2324.entities.Report;
import org.springframework.stereotype.Service;
import it.unicam.progettoids2324.Services.UserService;
import it.unicam.progettoids2324.entities.UserRole;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReportsService implements ReportsServiceInterface {
    private final ReportRepository reportRepository;
    private final UserService userService;

    public ReportsService(ReportRepository reportRepository,UserService userService) {
        this.reportRepository = reportRepository;
        this.userService = userService;
    }

    @Override
    public void createReport(long userId, String description) {
        if(this.userService.getUserById(userId).getRole() == UserRole.AUTHENTICATED_TOURIST){
        this.reportRepository.save(new Report(description));
        }
    }

    @Override
    public Set<ReportsDTO> getReports(long userId) {
        if(this.userService.getUserById(userId).getRole() != UserRole.CURATOR){
            throw new IllegalArgumentException("User not authorized");
        }
        Set<ReportsDTO> reports = new HashSet<>();
        for(Report report: this.reportRepository.findAll()) {
            reports.add(report.toDTO());
        }
        return reports;
    }

    @Override
    public void deleteReport(long id) {
        this.reportRepository.deleteById(id);
    }

    @Override
    public Report getReportsById(long id){
       return this.reportRepository.findById(id);
    }
}
