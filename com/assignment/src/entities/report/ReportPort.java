package com.assignment.src.entities.report;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ReportPort {
    int generateId() throws IOException;
    Report getReport(String[] strArray);
    ArrayList<String[]> getAllReport();
    Report getById(int id);
    ArrayList<String[]> getByCustomerId(int id);
    ArrayList<String[]> getByTrainerId(int id);
    ArrayList<String[]> getByMonth(LocalDateTime date);
    int modifyReport(Report report) throws IOException;
    int createReport(Report report) throws IOException;
    void generateReport(LocalDateTime date) throws IOException;
}
