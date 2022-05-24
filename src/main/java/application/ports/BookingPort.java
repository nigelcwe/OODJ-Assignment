package application.ports;

import domain.entities.Booking;

import java.io.IOException;
import java.util.ArrayList;

public interface BookingPort {
    int generateId() throws IOException;
    Booking getBooking(String[] strArray);
    ArrayList<String[]> getAllBooking() throws IOException;
    Booking getById(int id) throws IOException;
    ArrayList<String[]> getByCustomerId(int id) throws IOException;
    ArrayList<String[]> getByTrainerId(int id) throws IOException;
    ArrayList<String[]> getPaid() throws IOException;
    ArrayList<String[]> getUnpaid() throws IOException;
    ArrayList<String[]> getCompleted() throws IOException;
    ArrayList<String[]> getIncomplete() throws IOException;
    int modifyBooking(Booking booking) throws IOException;
    int deleteBooking(Booking booking) throws IOException;
    int createBooking(Booking booking) throws IOException;
}
