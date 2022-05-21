package entities.shared;

import impls.BookingImpl;
import impls.CustomerImpl;
import impls.ReportImpl;
import impls.StaffImpl;

public class GymSystem {
    public final StaffImpl staff = new StaffImpl();
    public final BookingImpl booking = new BookingImpl();
    public final CustomerImpl customer = new CustomerImpl();
    public final ReportImpl report = new ReportImpl();

    public GymSystem() throws Exception {
    }
}
