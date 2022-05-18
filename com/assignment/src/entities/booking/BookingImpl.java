package com.assignment.src.entities.booking;

import com.assignment.src.entities.shared.FileSelection;
import com.assignment.src.entities.shared.TextFile;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookingImpl implements BookingPort {
    private final File file = new File(FileSelection.Booking.toString());
    private final TextFile tf = new TextFile();
    public final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private ArrayList<String[]> allBooking = tf.readAll(file);

    public BookingImpl() throws IOException {
    }

    public void updateAllBooking() throws IOException {
        this.allBooking = tf.readAll(file);
    }

    @Override
    public ArrayList<String[]> getAllBooking() {
        return allBooking;
    }

    @Override
    public Booking getById(int id) {
        for (String[] i : allBooking) {
            if (Integer.parseInt(i[0]) == id) {
                return new Booking(
                        Integer.parseInt(i[0]),
                        Integer.parseInt(i[1]),
                        Integer.parseInt(i[2]),
                        LocalDateTime.parse(i[3], formatter),
                        LocalDateTime.parse(i[4], formatter),
                        LocalDateTime.parse(i[5], formatter),
                        Double.parseDouble(i[6]),
                        Boolean.parseBoolean(i[7]),
                        Boolean.parseBoolean(i[8]),
                        Integer.parseInt(i[9])
                );
            }
        }
        return null;
    }

    @Override
    public ArrayList<String[]> getByCustomerId(int id) {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allBooking) {
            if (Integer.parseInt(i[1]) == id) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getByTrainerId(int id) {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allBooking) {
            if (Integer.parseInt(i[2]) == id) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getPaid() {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allBooking) {
            if (Boolean.parseBoolean(i[8])) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getUnpaid() {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allBooking) {
            if (!Boolean.parseBoolean(i[8])) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getCompleted() {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allBooking) {
            if (Boolean.parseBoolean(i[7])) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public ArrayList<String[]> getIncomplete() {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allBooking) {
            if (!Boolean.parseBoolean(i[7])) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public int modifyBooking(Booking booking) throws IOException {
        ArrayList<String[]> oldAllBooking = new ArrayList<>();
        oldAllBooking.addAll(allBooking);
        updateAllBooking();

        for (String[] i : allBooking) {
            if (Integer.parseInt(i[0]) == booking.id) {
                i[0] = Integer.toString(booking.id);
                i[1] = Integer.toString(booking.customerId);
                i[2] = Integer.toString(booking.trainerId);
                i[3] = booking.creationDate.format(formatter);
                i[4] = booking.startTime.format(formatter);
                i[5] = booking.endTime.format(formatter);
                i[6] = Double.toString(booking.price);
                i[7] = Boolean.toString(booking.isCompleted);
                i[8] = Boolean.toString(booking.isPaid);
                i[9] = Integer.toString(booking.feedback);
                break;
            }
        }

        tf.write(file, allBooking);

        for (int i = 0; i < oldAllBooking.size(); i++) {
            String[] temp = oldAllBooking.get(i);
            String[] temp2 = allBooking.get(i);
            for (int j = 0; j < temp.length; j++) {
                if (!temp[j].equals(temp2[j])) return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteBooking(Booking booking) throws IOException {
        ArrayList<String[]> oldAllBooking = new ArrayList<>();
        oldAllBooking.addAll(allBooking);
        updateAllBooking();

        for (int i = 0; i < allBooking.size(); i++) {
            String[] j = allBooking.get(i);
            if (Integer.parseInt(j[0]) == booking.id) {
                allBooking.remove(i);
                break;
            }
        }

        tf.write(file, allBooking);

        if (oldAllBooking.size() > allBooking.size()) return 0;
        else return 1;    }

    @Override
    public int createBooking(Booking booking) throws IOException {
        String[] newBooking = {
                Integer.toString(booking.id),
                Integer.toString(booking.customerId),
                Integer.toString(booking.trainerId),
                booking.creationDate.format(formatter),
                booking.startTime.format(formatter),
                booking.endTime.format(formatter),
                Double.toString(booking.price),
                Boolean.toString(booking.isCompleted),
                Boolean.toString(booking.isPaid),
                Integer.toString(booking.feedback)
        };
        tf.append(file, newBooking);
        return 0;
    }
}
