package entities.shared;

public enum FileSelection {
    Booking("C:\\Users\\chanw\\repos\\OODJ-Assignment\\src\\main\\java\\data\\Booking.txt"),
    Customer("C:\\Users\\chanw\\repos\\OODJ-Assignment\\src\\main\\java\\data\\Customer.txt"),
    MonthlyReport("C:\\Users\\chanw\\repos\\OODJ-Assignment\\src\\main\\java\\data\\MonthlyReport.pdf"),
    Report("C:\\Users\\chanw\\repos\\OODJ-Assignment\\src\\main\\java\\data\\Report.txt"),
    Staff("C:\\Users\\chanw\\repos\\OODJ-Assignment\\src\\main\\java\\data\\Staff.txt");

    private final String value;

    FileSelection(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
