package com.assignment.src.entities.shared;

import com.assignment.src.entities.booking.BookingImpl;
import com.assignment.src.entities.customer.CustomerImpl;
import com.assignment.src.entities.report.ReportImpl;
import com.assignment.src.entities.staff.StaffImpl;

import java.io.IOException;

public class GymSystem {
    public final StaffImpl staff = new StaffImpl();
    public final BookingImpl booking = new BookingImpl();
    public final CustomerImpl customer = new CustomerImpl();
    public final ReportImpl report = new ReportImpl();

    public GymSystem() throws Exception {
    }
}
