package entities.shared;

import impls.ReportImpl;
import impls.StaffImpl;
import impls.BookingImpl;
import impls.CustomerImpl;

public class GymSystem {
    public final StaffImpl staff = new StaffImpl();
    public final BookingImpl booking = new BookingImpl();
    public final CustomerImpl customer = new CustomerImpl();
    public final ReportImpl report = new ReportImpl();

    public GymSystem() throws Exception {
    }
}
