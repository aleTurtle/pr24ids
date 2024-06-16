package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Repositories.ReportRepository;
import it.unicam.progettoids2324.Services.ReportsService;
import it.unicam.progettoids2324.dtos.Requests.AddReportsRequest;
import it.unicam.progettoids2324.entities.Report;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ReportsController")
public class ReportsController {
    private final ReportRepository reportRepository;
    private final ReportsService reportsService;

    @Autowired
    public ReportsController(ReportRepository reportRepository, ReportsService reportsService) {
        this.reportRepository = reportRepository;
        this.reportsService = reportsService;
    }

    @PostMapping("/CreateReports/")
    public ResponseEntity<Report> createReports(@RequestBody AddReportsRequest request) {
        Report report = new Report(request.description());
        this.reportRepository.save(report);
        return ResponseEntity.ok().body(report);
    }

    @GetMapping("/getReports/{userid}")
    public ResponseEntity<Object> getContests(@PathVariable long userid) {
        try {
            return ResponseEntity.ok(this.reportsService.getReports(userid));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/DeleteReport/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable long userId){
        this.reportsService.deleteReport(userId);
        return ResponseEntity.ok().body("Report deleted");
    }
    /*

    @PutMapping("/resolveReport/{userId}/{reportId}")
    public ResponseEntity<Object> openContest(@PathVariable long userId, @PathVariable long contestId) {
        try {
            this.contestService.openContest(userId, contestId);
            return ResponseEntity.ok("Contest opened successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
