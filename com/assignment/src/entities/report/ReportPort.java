package com.assignment.src.entities.report;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ReportPort {
    int generateId() throws IOException;
    ArrayList<String[]> getAllReport();
    Report getById(int id);
    ArrayList<String[]> getByCustomerId(int id);
    ArrayList<String[]> getByTrainerId(int id);
    ArrayList<String[]> getByManagerId(int id);
    ArrayList<String[]> getPaid();
    ArrayList<String[]> getUnpaid();
    ArrayList<String[]> getByMonth(LocalDateTime date);
    int modifyReport(Report report) throws IOException;
    int createReport(Report report) throws IOException;
}
