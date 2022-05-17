package com.assignment.src.entities.shared;

import com.assignment.src.entities.booking.BookingImpl;
import com.assignment.src.entities.customer.CustomerImpl;
import com.assignment.src.entities.report.ReportImpl;
import com.assignment.src.entities.staff.StaffImpl;

import java.io.IOException;

public class GymSystem {
    public StaffImpl staff;
    public BookingImpl booking;
    public CustomerImpl customer;
    public ReportImpl report;

    public GymSystem() throws IOException {
        this.staff = new StaffImpl();
        this.booking = new BookingImpl();
        this.customer = new CustomerImpl();
        this.report = new ReportImpl();
    }
}
