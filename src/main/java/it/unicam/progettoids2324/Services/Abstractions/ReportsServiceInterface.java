package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.dtos.ReportsDTO;
import it.unicam.progettoids2324.entities.Report;

import java.util.Set;

public interface ReportsServiceInterface {

    void createReport(long userId, String description);

    Set<ReportsDTO> getReports(long userId);

    void deleteReport(long id);

    Report getReportsById(long id);

}
