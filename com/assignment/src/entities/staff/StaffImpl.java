package com.assignment.src.entities.staff;
import com.assignment.src.entities.shared.FileSelection;
import com.assignment.src.entities.shared.TextFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StaffImpl implements StaffPort {
    private final File file = new File(FileSelection.Staff.toString());
    private final TextFile tf = new TextFile();
    private ArrayList<String[]> allStaff = tf.readAll(file);

    public StaffImpl() throws IOException {
    }

    public void updateAllStaff() throws IOException {
        this.allStaff = tf.readAll(file);
    }

    @Override
    public int generateId() throws IOException {
        ArrayList<String[]> reverseAllStaff = new ArrayList<>();
        reverseAllStaff.addAll(allStaff);
        updateAllStaff();
        Collections.reverse(reverseAllStaff);
        return Integer.parseInt(reverseAllStaff.get(0)[0]) + 1;
    }

    @Override
    public ArrayList<String[]> getAllStaff() {
        return allStaff;
    }

    @Override
    public Staff getById(int id) {
        for (String[] i : allStaff) {
            if (Integer.parseInt(i[0]) == id) {
                return new Staff(Integer.parseInt(i[0]), i[1], i[2], i[3], i[4], i[5], i[6], i[7], Role.valueOf(i[8]));
            }
        }
        return null;
    }

    @Override
    public Staff getByUsername(String username) {
        for (String[] i : allStaff) {
            if (i[5].equals(username)) {
                return new Staff(Integer.parseInt(i[0]), i[1], i[2], i[3], i[4], i[5], i[6], i[7], Role.valueOf(i[8]));
            }
        }
        return null;
    }

    @Override
    public int modifyStaff(Staff staff) throws IOException {
        ArrayList<String[]> oldAllStaff = new ArrayList<>();
        oldAllStaff.addAll(allStaff);
        updateAllStaff();

        for (String[] i : allStaff) {
            if (Integer.parseInt(i[0]) == staff.id) {
                i[0] = String.valueOf(staff.id);
                i[1] = staff.firstName;
                i[2] = staff.lastName;
                i[3] = staff.phoneNum;
                i[4] = staff.email;
                i[5] = staff.username;
                i[6] = staff.password;
                i[7] = staff.icNum;
                i[8] = staff.role.toString();
                break;
            }
        }

        tf.write(file, allStaff);

        for (int i = 0; i < oldAllStaff.size(); i++) {
            String[] temp = oldAllStaff.get(i);
            String[] temp2 = allStaff.get(i);
            for (int j = 0; j < temp.length; j++) {
                if (!temp[j].equals(temp2[j])) return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteStaff(Staff staff) throws IOException {
        ArrayList<String[]> oldAllStaff = new ArrayList<>();
        oldAllStaff.addAll(allStaff);
        updateAllStaff();

        for (int i = 0; i < allStaff.size(); i++) {
            String[] j = allStaff.get(i);
            if (Integer.parseInt(j[0]) == staff.id) {
                allStaff.remove(i);
                break;
            }
        }

        tf.write(file, allStaff);

        if (oldAllStaff.size() > allStaff.size()) return 0;
        else return 1;
    }

    @Override
    public int login(String username, String password) {
        for (String[] i : allStaff) {
            if ((username.equals(i[5])) && (password.equals(i[6]))) return 0;
        }
        return 1;
    }


//    no validation performed here, please validate before using
    @Override
    public int createStaff(Staff staff) throws IOException {
        String[] newStaff = {
                Integer.toString(staff.id),
                staff.firstName,
                staff.lastName,
                staff.phoneNum,
                staff.email,
                staff.username,
                staff.password,
                staff.icNum,
                staff.role.toString()
        };
        tf.append(file, newStaff);
        return 0;
    }
}

