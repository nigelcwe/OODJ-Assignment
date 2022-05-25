package application.ports;

import domain.entities.Report;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ReportPort {
    int generateId() throws IOException;
    Report getReport(String[] strArray);
    ArrayList<String[]> getAllReport() throws IOException;
    Report getById(int id) throws IOException;
    ArrayList<String[]> getByCustomerId(int id) throws IOException;
    ArrayList<String[]> getByTrainerId(int id) throws IOException;
    ArrayList<String[]> getByMonthAndYear(LocalDateTime date) throws IOException;
    int modifyReport(Report report) throws IOException;
    int createReport(Report report) throws IOException;
    int generateReport(LocalDateTime date) throws IOException;
}
