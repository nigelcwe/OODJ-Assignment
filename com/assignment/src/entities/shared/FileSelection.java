package com.assignment.src.entities.shared;

public enum FileSelection {
    Booking("C:\\Users\\chanw\\repos\\OODJ-Assignment\\com\\assignment\\src\\data\\Booking.txt"),
    Customer("C:\\Users\\chanw\\repos\\OODJ-Assignment\\com\\assignment\\src\\data\\Customer.txt"),
    MonthlyReport("C:\\Users\\chanw\\repos\\OODJ-Assignment\\com\\assignment\\src\\data\\MonthlyReport.pdf"),
    Report("C:\\Users\\chanw\\repos\\OODJ-Assignment\\com\\assignment\\src\\data\\Report.txt"),
    Staff("C:\\Users\\chanw\\repos\\OODJ-Assignment\\com\\assignment\\src\\data\\Staff.txt");

    private final String value;

    FileSelection(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
