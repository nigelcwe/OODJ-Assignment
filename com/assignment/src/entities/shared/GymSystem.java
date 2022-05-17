package com.assignment.src.entities.shared;

import com.assignment.src.entities.booking.BookingImpl;
import com.assignment.src.entities.customer.CustomerImpl;
import com.assignment.src.entities.report.ReportImpl;
import com.assignment.src.entities.staff.StaffImpl;

public class GymSystem {
    public StaffImpl staff;
    public BookingImpl booking;
    public CustomerImpl customer;
    public ReportImpl report;

    public GymSystem(StaffImpl staff, BookingImpl booking, CustomerImpl customer, ReportImpl report) {
        this.staff = staff;
        this.booking = booking;
        this.customer = customer;
        this.report = report;
    }
}
