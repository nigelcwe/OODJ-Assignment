package com.assignment.src.entities.staff;

public interface StaffPort {
    Staff[] getAllStaff();
    Staff getById(int id);
    Staff getByUsername(String username);
    int modifyStaff(Staff staff);
    int deleteStaff(Staff staff);
    int login(String username, String password);
}
