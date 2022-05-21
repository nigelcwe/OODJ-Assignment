package entities.shared;

import entities.booking.BookingImpl;
import entities.customer.CustomerImpl;
import entities.report.ReportImpl;
import entities.staff.StaffImpl;

public class GymSystem {
    public final StaffImpl staff = new StaffImpl();
    public final BookingImpl booking = new BookingImpl();
    public final CustomerImpl customer = new CustomerImpl();
    public final ReportImpl report = new ReportImpl();

    public GymSystem() throws Exception {
    }
}
