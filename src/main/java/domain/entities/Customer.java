package domain.entities;

import domain.entities.shared.Human;

public class Customer extends Human {
    protected int bookingId;

    public Customer(int id, String firstName, String lastName, String phoneNum, String email, int bookingId) {
        super(id, firstName, lastName, phoneNum, email);
        this.bookingId = bookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
