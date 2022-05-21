package entities;

import entities.shared.Human;
import enums.Role;

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
}
