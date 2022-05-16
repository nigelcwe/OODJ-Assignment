package com.assignment.src.entities.shared;

public abstract class Human extends Entity {
    public String firstName;
    public String lastName;
    public String fullName;
    public String phoneNum;
    public String email;

    public Human(int id, String firstName, String lastName, String phoneNum, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.fullName = firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return fullName;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getEmail() {
        return email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
