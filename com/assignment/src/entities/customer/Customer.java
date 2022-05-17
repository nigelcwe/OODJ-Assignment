package com.assignment.src.entities.customer;

import com.assignment.src.entities.shared.Human;

public class Customer extends Human {
    public int bookingId;

    public Customer(int id, String firstName, String lastName, String phoneNum, String email, int bookingId) {
        super(id, firstName, lastName, phoneNum, email);
        this.bookingId = bookingId;
    }
}
