package domain.enums;

public enum Separator {
    Underscore("_");

    private final String value;

    Separator(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}