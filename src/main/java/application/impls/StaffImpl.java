package application.impls;
import application.ports.StaffPort;
import domain.enums.FileSelection;
import application.entities.TextFile;
import domain.enums.Role;
import domain.entities.Staff;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StaffImpl implements StaffPort {
    private final File file = new File(FileSelection.Staff.toString());
    private final TextFile tf = new TextFile();
    private ArrayList<String[]> allStaff = tf.readAll(file);
    public final String[] invalidChars = {"(", ")","{", "}", "[", "]", "|", "`", "\\", "\"", "!", "@", "#", "$", "%", "^", "&", "*", ":", ";", "-", "_", "=", "+"};

    public StaffImpl() throws IOException {
    }

    private void updateAllStaff() throws IOException {
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
    public Staff getStaff(String[] strArray) {
        return new Staff(
                Integer.parseInt(strArray[0]),
                strArray[1],
                strArray[2],
                strArray[3],
                strArray[4],
                strArray[5],
                strArray[6],
                strArray[7],
                Role.valueOf(strArray[8])
        );
    }

    @Override
    public ArrayList<String[]> getAllStaff() {
        return allStaff;
    }

    @Override
    public ArrayList<String[]> getByRole(Role role) {
        ArrayList<String[]> finalArrayList = new ArrayList<>();

        for (String[] i : allStaff) {
            if (i[8].equals(role.toString())) {
                finalArrayList.add(i);
            }
        }

        if (finalArrayList.size() > 0) {return finalArrayList;}
        else {return null;}
    }

    @Override
    public Staff getById(int id) {
        for (String[] i : allStaff) {
            if (Integer.parseInt(i[0]) == id) {
                return getStaff(i);
            }
        }
        return null;
    }

    @Override
    public Staff getByUsername(String username) {
        for (String[] i : allStaff) {
            if (i[5].equals(username)) {
                return new Staff(
                        Integer.parseInt(i[0]),
                        i[1],
                        i[2],
                        i[3],
                        i[4],
                        i[5],
                        i[6],
                        i[7],
                        Role.valueOf(i[8])
                );
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
            if (Integer.parseInt(i[0]) == staff.getId()) {
                i[0] = String.valueOf(staff.getId());
                i[1] = staff.getFirstName();
                i[2] = staff.getLastName();
                i[3] = staff.getPhoneNum();
                i[4] = staff.getEmail();
                i[5] = staff.getUsername();
                i[6] = staff.getPassword();
                i[7] = staff.getIcNum();
                i[8] = staff.getRole().toString();
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

//    no validation performed here, please validate before using
    @Override
    public int createStaff(Staff staff) throws IOException {
        String[] newStaff = {
                Integer.toString(staff.getId()),
                staff.getFirstName(),
                staff.getLastName(),
                staff.getPhoneNum(),
                staff.getEmail(),
                staff.getUsername(),
                staff.getPassword(),
                staff.getIcNum(),
                staff.getRole().toString()
        };
        tf.append(file, newStaff);
        return 0;
    }

    @Override
    public Staff login(String username, String password) {
        for (String[] i : allStaff) {
            if ((username.equals(i[5])) && (password.equals(i[6]))) {
                return new Staff(
                        Integer.parseInt(i[0]),
                        i[1],
                        i[2],
                        i[3],
                        i[4],
                        i[5],
                        i[6],
                        i[7],
                        Role.valueOf(i[8])
                );
            }
        }
        return null;
    }

    @Override
    public int validation(String usernameOrPassword) {
        for (String i : invalidChars) {
            if (usernameOrPassword.contains(i)) return 1;
        }
        return 0;
    }
}

