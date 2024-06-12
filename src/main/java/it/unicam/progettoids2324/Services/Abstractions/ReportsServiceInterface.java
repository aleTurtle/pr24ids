package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.Reports;

import java.util.Set;

public interface ReportsServiceInterface {

    void createReport(String description);

    Set<Reports> getReports();

    void deleteReport(long id);

    Reports getReportsById(long id);

}
