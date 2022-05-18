package com.assignment.src.entities.staff;

import com.assignment.src.entities.shared.Human;

public class Staff extends Human {
    public String username, password, icNum;
    public Role role;

    public Staff(int id, String firstName, String lastName, String phoneNum, String email, String username, String password, String icNum, Role role) {
        super(id, firstName, lastName, phoneNum, email);
        this.username = username;
        this.password = password;
        this.icNum = icNum;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIcNum() {
        return icNum;
    }
    public void setIcNum(String icNum) {
        this.icNum = icNum;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
