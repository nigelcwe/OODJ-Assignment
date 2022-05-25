package application.impls;

import application.ports.ReportPort;
import domain.entities.Report;
import domain.entities.Staff;
import domain.enums.FileSelection;
import domain.enums.Role;
import application.entities.TextFile;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;

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

    private void updateAllReport() throws IOException {
        this.allReport = tf.readAll(file);
    }

    @Override
    public int generateId() throws IOException {
        updateAllReport();
        ArrayList<String[]> reverseAllReport = new ArrayList<>();
        reverseAllReport.addAll(allReport);
        updateAllReport();
        Collections.reverse(reverseAllReport);
        return Integer.parseInt(reverseAllReport.get(0)[0]) + 1;
    }

    @Override
    public Report getReport(String[] strArray) {
        return new Report(
                Integer.parseInt(strArray[0]),
                Integer.parseInt(strArray[1]),
                Integer.parseInt(strArray[2]),
                Double.parseDouble(strArray[3]),
                LocalDateTime.parse(strArray[5], formatter)
        );
    }

    @Override
    public ArrayList<String[]> getAllReport() throws IOException {
        updateAllReport();
        return allReport;
    }

    @Override
    public Report getById(int id) throws IOException {
        updateAllReport();
        for (String[] i : allReport) {
            if (Integer.parseInt(i[0]) == id) {
                return getReport(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<String[]> getByCustomerId(int id) throws IOException {
        updateAllReport();
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
    public ArrayList<String[]> getByTrainerId(int id) throws IOException {
        updateAllReport();
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
    public ArrayList<String[]> getByMonthAndYear(LocalDateTime date) throws IOException {
        updateAllReport();
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allReport) {
            if (LocalDateTime.parse(i[5], formatter).getYear() != date.getYear()) continue;
            if (LocalDateTime.parse(i[5], formatter).getMonth().compareTo(date.getMonth()) == 0) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public int modifyReport(Report report) throws IOException {
        updateAllReport();
        ArrayList<String[]> oldAllReport = new ArrayList<>();
        oldAllReport.addAll(allReport);
        updateAllReport();

        for (String[] i : allReport) {
            if (Integer.parseInt(i[0]) == report.getId()) {
                i[0] = Integer.toString(report.getId());
                i[1] = Integer.toString(report.getCustomerId());
                i[2] = Integer.toString(report.getTrainerId());
                i[3] = Double.toString(report.getPaymentAmount());
                i[4] = Double.toString(report.getCommission());
                i[5] = report.getCreationDate().format(formatter);
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
                Integer.toString(report.getId()),
                Integer.toString(report.getCustomerId()),
                Integer.toString(report.getTrainerId()),
                Double.toString(report.getPaymentAmount()),
                Double.toString(report.getCommission()),
                report.getCreationDate().format(formatter),
        };
        tf.append(file, newReport);
        return 0;
    }

    @Override
    public int generateReport(LocalDateTime date) throws IOException {
        StaffImpl si = new StaffImpl();
        ArrayList<String[]> reportByMonth = this.getByMonthAndYear(date);
        ArrayList<String[]> allTrainer = si.getByRole(Role.Trainer);

        PdfWriter writer = new PdfWriter(FileSelection.MonthlyReport.toString());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);

        PdfFont courierBold = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);
        PdfFont courier = PdfFontFactory.createFont(StandardFonts.COURIER);

        Paragraph title = new Paragraph("MONTHLY REPORT FOR " + date.getMonth().toString() + " " + date.getYear()).setFontSize(20).setFont(courierBold);
        doc.add(title);

        float[] columnWidths = {45F, 160F, 45F, 90F, 90F, 90F};
        Table table = new Table(columnWidths).setHorizontalAlignment(HorizontalAlignment.CENTER);

//        Adding Header Cells
        table.addHeaderCell(new Paragraph("ID").setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.CENTER))
                .addHeaderCell(new Paragraph("TRAINER NAME").setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.CENTER))
                .addHeaderCell(new Paragraph("SALES").setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.CENTER))
                .addHeaderCell(new Paragraph("REVENUE").setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.CENTER))
                .addHeaderCell(new Paragraph("COMMISSION").setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.CENTER))
                .addHeaderCell(new Paragraph("PROFIT").setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.CENTER));

        double totalProfit = 0;

//        Analysis Algorithm
        for (String[] i : allTrainer) {
            Staff trainer = si.getStaff(i);
            int sales = 0;
            double revenue = 0, commission = 0, profit;

            for (String[] j : reportByMonth) {
                if (i[0].equals(j[2])) {
                    sales = sales + 1;
                    revenue = revenue + Double.parseDouble(j[3]);
                    commission = commission + Double.parseDouble(j[4]);
                }
            }
            profit = revenue - commission;
            totalProfit = totalProfit + profit;

//            Adding Content Cells
            table.addCell(new Paragraph(Integer.toString(trainer.getId())).setFont(courier).setFontSize(12).setTextAlignment(TextAlignment.RIGHT))
                    .addCell(new Paragraph(trainer.getFullName()).setFont(courier).setFontSize(12).setTextAlignment(TextAlignment.LEFT))
                    .addCell(new Paragraph(Integer.toString(sales)).setFont(courier).setFontSize(12).setTextAlignment(TextAlignment.RIGHT))
                    .addCell(new Paragraph(Double.toString(revenue)).setFont(courier).setFontSize(12).setTextAlignment(TextAlignment.RIGHT))
                    .addCell(new Paragraph(Double.toString(commission)).setFont(courier).setFontSize(12).setTextAlignment(TextAlignment.RIGHT))
                    .addCell(new Paragraph(Double.toString(profit)).setFont(courier).setFontSize(12).setTextAlignment(TextAlignment.RIGHT));
        }


//        Adding Footer Cells
        Cell cell = new Cell(1, 5).add(new Paragraph("TOTAL PROFIT:")).setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.CENTER);
        table.addFooterCell(cell).addFooterCell(new Paragraph(Double.toString(totalProfit)).setFont(courierBold).setFontSize(14).setTextAlignment(TextAlignment.RIGHT));

        doc.add(table);

        doc.close();
        return 0;
    }
}
