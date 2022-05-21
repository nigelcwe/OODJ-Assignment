package entities.shared;

public abstract class Human extends Entity {
    public String firstName, lastName, fullName, phoneNum, email;

    public Human(int id, String firstName, String lastName, String phoneNum, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.fullName = firstName + " " + lastName;
    }
}
