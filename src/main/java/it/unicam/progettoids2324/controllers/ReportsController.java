package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Repositories.ReportRepository;
import it.unicam.progettoids2324.Services.ManagerService;
import it.unicam.progettoids2324.Services.ReportsService;
import it.unicam.progettoids2324.dtos.Requests.AddReportsRequest;
import it.unicam.progettoids2324.entities.Manager;
import it.unicam.progettoids2324.entities.Reports;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ReportsController")
public class ReportsController {
    private final ReportRepository reportRepository;
    private final ReportsService reportsService;
    private final ManagerService managerService;

    @Autowired
    public ReportsController(ReportRepository reportRepository, ReportsService reportsService, ManagerService managerService) {
        this.reportRepository = reportRepository;
        this.managerService = managerService;
        this.reportsService = reportsService;
    }

    @PostMapping("/CreateReports/")
    public ResponseEntity<Reports> createReports(@RequestBody AddReportsRequest request) {
        Reports report = new Reports(request.description());
        this.reportRepository.save(report);
        return ResponseEntity.ok().body(report);
    }

    @GetMapping("/GetReports/{managerId}")
    public ResponseEntity<Object> getReports(@PathVariable long managerId){
        if(this.managerService.getManagerById(managerId).getRole() != UserRole.MANAGER){
            throw new IllegalArgumentException("The user is'n a MANAGER");
        }
        return ResponseEntity.ok().body(this.reportRepository.findAll());
    }


    @DeleteMapping("/DeleteReports/{managerId}/{reportsId}")
    public ResponseEntity<Object> deleteReports(@PathVariable long managerId, @PathVariable long reportsId) {
        Manager manager = this.managerService.getManagerById(managerId);
        if (manager == null || manager.getRole() != UserRole.MANAGER) {
            throw new IllegalArgumentException("Manager non valido");
        }

        Reports report = this.reportRepository.findById(reportsId);
        if (report == null) {
            throw new IllegalArgumentException("Report non trovato");
        }


        reportsService.deleteReport(reportsId);
        return ResponseEntity.ok().body("Report eliminato con successo");
    }

}
