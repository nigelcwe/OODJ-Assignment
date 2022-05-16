package com.assignment.src.entities.shared;

public enum FileSelection {
    Staff("C:\\Users\\chanw\\repos\\OODJ-Assignment\\com\\assignment\\src\\data\\Staff.txt"),
    Customer(""),
    Booking(""),
    Report("");

    private final String value;

    FileSelection(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
