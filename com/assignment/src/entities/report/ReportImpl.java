package com.assignment.src.entities.report;

import com.assignment.src.entities.shared.FileSelection;
import com.assignment.src.entities.shared.TextFile;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class ReportImpl implements ReportPort {
    private final File file = new File(FileSelection.Report.toString());
    private final TextFile tf = new TextFile();
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private ArrayList<String[]> allReport = tf.readAll(file);

    public ReportImpl() throws IOException {
    }

    public void updateAllReport() throws IOException {
        this.allReport = tf.readAll(file);
    }

    @Override
    public int generateId() throws IOException {
        ArrayList<String[]> reverseAllReport = new ArrayList<>();
        reverseAllReport.addAll(allReport);
        updateAllReport();
        Collections.reverse(reverseAllReport);
        return Integer.parseInt(reverseAllReport.get(0)[0]) + 1;
    }

    @Override
    public ArrayList<String[]> getAllReport() {
        return allReport;
    }

    @Override
    public Report getById(int id) {
        for (String[] i : allReport) {
            if (Integer.parseInt(i[0]) == id) {
                return new Report(
                        Integer.parseInt(i[0]),
                        Integer.parseInt(i[1]),
                        Integer.parseInt(i[2]),
                        Double.parseDouble(i[3]),
                        Double.parseDouble(i[4]),
                        LocalDateTime.parse(i[5], formatter)
                );
            }
        }
        return null;
    }

    @Override
    public ArrayList<String[]> getByCustomerId(int id) {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allReport) {
            if (Integer.parseInt(i[1]) == id) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getByTrainerId(int id) {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allReport) {
            if (Integer.parseInt(i[2]) == id) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getByManagerId(int id) {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allReport) {
            if (Integer.parseInt(i[3]) == id) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getPaid() {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allReport) {
            if (Boolean.parseBoolean(i[5])) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getUnpaid() {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allReport) {
            if (!Boolean.parseBoolean(i[5])) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getByMonth(LocalDateTime date) {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allReport) {
            if (LocalDateTime.parse(i[6], formatter).getMonth().compareTo(date.getMonth()) == 0) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public int modifyReport(Report report) throws IOException {
        ArrayList<String[]> oldAllReport = new ArrayList<>();
        oldAllReport.addAll(allReport);
        updateAllReport();

        for (String[] i : allReport) {
            if (Integer.parseInt(i[0]) == report.id) {
                i[0] = Integer.toString(report.id);
                i[1] = Integer.toString(report.customerId);
                i[2] = Integer.toString(report.trainerId);
                i[3] = Double.toString(report.paymentAmount);
                i[4] = Double.toString(report.commission);
                i[5] = report.creationDate.format(formatter);
                break;
            }
        }

        tf.write(file, allReport);

        for (int i = 0; i < oldAllReport.size(); i++) {
            String[] temp = oldAllReport.get(i);
            String[] temp2 = allReport.get(i);
            for (int j = 0; j < temp.length; j++) {
                if (!temp[j].equals(temp2[j])) return 0;
            }
        }
        return 1;
    }

    @Override
    public int createReport(Report report) throws IOException {
        String[] newReport = {
                Integer.toString(report.id),
                Integer.toString(report.customerId),
                Integer.toString(report.trainerId),
                Double.toString(report.paymentAmount),
                Double.toString(report.commission),
                report.creationDate.format(formatter),
        };
        tf.append(file, newReport);
        return 0;
    }
}
