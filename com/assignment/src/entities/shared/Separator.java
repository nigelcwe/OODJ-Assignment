package com.assignment.src.entities.shared;

public enum Separator {
    Comma(","),
    VerticalBar("|");

    private final String value;

    Separator(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}