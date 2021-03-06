package application.impls;

import application.ports.BookingPort;
import domain.entities.Booking;
import application.entities.TextFile;
import domain.enums.FileSelection;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class BookingImpl implements BookingPort {
    private final File file = new File(FileSelection.Booking.toString());
    private final TextFile tf = new TextFile();
    public final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private ArrayList<String[]> allBooking = tf.readAll(file);

    public BookingImpl() throws IOException {
    }

    private void updateAllBooking() throws IOException {
        this.allBooking = tf.readAll(file);
    }

    @Override
    public int generateId() throws IOException {
        updateAllBooking();
        updateAllBooking();
        ArrayList<String[]> reverseAllBooking = new ArrayList<>();
        reverseAllBooking.addAll(allBooking);
        updateAllBooking();
        Collections.reverse(reverseAllBooking);
        return Integer.parseInt(reverseAllBooking.get(0)[0]) + 1;
    }

    @Override
    public Booking getBooking(String[] strArray) {
        return new Booking(
                Integer.parseInt(strArray[0]),
                Integer.parseInt(strArray[1]),
                Integer.parseInt(strArray[2]),
                LocalDateTime.parse(strArray[3], formatter),
                LocalDateTime.parse(strArray[4], formatter),
                LocalDateTime.parse(strArray[5], formatter),
                Double.parseDouble(strArray[6]),
                Boolean.parseBoolean(strArray[7]),
                Boolean.parseBoolean(strArray[8]),
                strArray[9]
        );
    }

    @Override
    public ArrayList<String[]> getAllBooking() throws IOException {
        updateAllBooking();
        return allBooking;
    }

    @Override
    public Booking getById(int id) throws IOException {
        updateAllBooking();
        for (String[] i : allBooking) {
            if (Integer.parseInt(i[0]) == id) {
                return getBooking(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<String[]> getByCustomerId(int id) throws IOException {
        updateAllBooking();
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
    public ArrayList<String[]> getByTrainerId(int id) throws IOException {
        updateAllBooking();
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
    public ArrayList<String[]> getPaid() throws IOException {
        updateAllBooking();
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
    public ArrayList<String[]> getUnpaid() throws IOException {
        updateAllBooking();
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
    public ArrayList<String[]> getCompleted() throws IOException {
        updateAllBooking();
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
    public ArrayList<String[]> getIncomplete() throws IOException {
        updateAllBooking();
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
            if (Integer.parseInt(i[0]) == booking.getId()) {
                i[0] = Integer.toString(booking.getId());
                i[1] = Integer.toString(booking.getCustomerId());
                i[2] = Integer.toString(booking.getTrainerId());
                i[3] = booking.getCreationDate().format(formatter);
                i[4] = booking.getStartTime().format(formatter);
                i[5] = booking.getEndTime().format(formatter);
                i[6] = Double.toString(booking.getPrice());
                i[7] = Boolean.toString(booking.isCompleted());
                i[8] = Boolean.toString(booking.isPaid());
                i[9] = booking.getFeedback();
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
            if (Integer.parseInt(j[0]) == booking.getId()) {
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
                Integer.toString(booking.getId()),
                Integer.toString(booking.getCustomerId()),
                Integer.toString(booking.getTrainerId()),
                booking.getCreationDate().format(formatter),
                booking.getStartTime().format(formatter),
                booking.getEndTime().format(formatter),
                Double.toString(booking.getPrice()),
                Boolean.toString(booking.isCompleted()),
                Boolean.toString(booking.isPaid()),
                booking.getFeedback()
        };
        tf.append(file, newBooking);
        return 0;
    }
}
