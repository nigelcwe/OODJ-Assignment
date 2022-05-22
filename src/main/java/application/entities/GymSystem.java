package application.entities;

import application.impls.ReportImpl;
import application.impls.StaffImpl;
import application.impls.BookingImpl;
import application.impls.CustomerImpl;

public class GymSystem {
    public final StaffImpl staff = new StaffImpl();
    public final BookingImpl booking = new BookingImpl();
    public final CustomerImpl customer = new CustomerImpl();
    public final ReportImpl report = new ReportImpl();

    public GymSystem() throws Exception {
    }

    public StaffImpl getStaff() {
        return staff;
    }

    public BookingImpl getBooking() {
        return booking;
    }

    public CustomerImpl getCustomer() {
        return customer;
    }

    public ReportImpl getReport() {
        return report;
    }
}
