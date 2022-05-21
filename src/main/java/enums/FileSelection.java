package enums;

public enum FileSelection {
    Booking("C:\\Users\\Johan\\Desktop\\Software Engineering\\Year 2 - SEM 1\\Object oriented development with Java\\Assignment\\OODJ-Assignment\\src\\main\\java\\data\\Booking.txt"),
    Customer("C:\\Users\\Johan\\Desktop\\Software Engineering\\Year 2 - SEM 1\\Object oriented development with Java\\Assignment\\OODJ-Assignment\\src\\main\\java\\data\\Customer.txt"),
    MonthlyReport("C:\\Users\\Johan\\Desktop\\Software Engineering\\Year 2 - SEM 1\\Object oriented development with Java\\Assignment\\OODJ-Assignment\\src\\main\\java\\data\\MonthlyReport.pdf"),
    Report("C:\\Users\\Johan\\Desktop\\Software Engineering\\Year 2 - SEM 1\\Object oriented development with Java\\Assignment\\OODJ-Assignment\\src\\main\\java\\data\\Report.txt"),
    Staff("C:\\Users\\Johan\\Desktop\\Software Engineering\\Year 2 - SEM 1\\Object oriented development with Java\\Assignment\\OODJ-Assignment\\src\\main\\java\\data\\Staff.txt");

    private final String value;

    FileSelection(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
