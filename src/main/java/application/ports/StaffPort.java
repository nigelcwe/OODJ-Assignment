package application.ports;

import domain.enums.Role;
import domain.entities.Staff;

import java.io.IOException;
import java.util.ArrayList;

public interface StaffPort {
    int generateId() throws IOException;
    Staff getStaff(String[] strArray);
    ArrayList<String[]> getAllStaff() throws IOException;
    ArrayList<String[]> getByRole(Role role) throws IOException;
    Staff getById(int id) throws IOException;
    Staff getByUsername(String username) throws IOException;
    int modifyStaff(Staff staff) throws IOException;
    int createStaff(Staff staff) throws IOException;
    Staff login(String username, String password) throws IOException;
    int validation (String usernameOrPassword);
}
