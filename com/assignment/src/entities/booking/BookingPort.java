package com.assignment.src.entities.booking;

import java.io.IOException;
import java.util.ArrayList;

public interface BookingPort {
    ArrayList<String[]> getAllBooking();
    Booking getById(int id);
    ArrayList<String[]> getByCustomerId(int id);
    ArrayList<String[]> getByTrainerId(int id);
    ArrayList<String[]> getPaid();
    ArrayList<String[]> getUnpaid();
    ArrayList<String[]> getCompleted();
    ArrayList<String[]> getIncomplete();
    int modifyBooking(Booking booking) throws IOException;
    int deleteBooking(Booking booking) throws IOException;
    int createBooking(Booking booking) throws IOException;
}
