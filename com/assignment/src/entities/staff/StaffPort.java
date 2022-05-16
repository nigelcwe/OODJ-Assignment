package com.assignment.src.entities.staff;

import java.io.IOException;
import java.util.ArrayList;

public interface StaffPort {
    ArrayList<String[]> getAllStaff() throws IOException;
    Staff getById(int id);
    Staff getByUsername(String username);
    int modifyStaff(Staff staff) throws IOException;
    int deleteStaff(Staff staff) throws IOException;
    int login(String username, String password);
    int createStaff(Staff staff) throws IOException;
}
