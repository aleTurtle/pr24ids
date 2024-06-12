package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.ReportRepository;
import it.unicam.progettoids2324.Services.Abstractions.ReportsServiceInterface;
import it.unicam.progettoids2324.entities.Reports;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReportsService implements ReportsServiceInterface {
    private final ReportRepository reportRepository;

    public ReportsService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void createReport(String description) {
        this.reportRepository.save(new Reports(description));
    }

    @Override
    public Set<Reports> getReports() {
        Set<Reports> reports = new HashSet<>();
        for(Reports report: this.reportRepository.findAll()) {
            reports.add(report);
        }
        return reports;
    }

    @Override
    public void deleteReport(long id) {
        this.reportRepository.deleteById(id);
    }

    @Override
    public Reports getReportsById(long id){
       return this.reportRepository.findById(id);
    }
}
