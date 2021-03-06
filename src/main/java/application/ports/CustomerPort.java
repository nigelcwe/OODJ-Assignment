package application.ports;

import domain.entities.Customer;

import java.io.IOException;
import java.util.ArrayList;

public interface CustomerPort {
    int generateId() throws IOException;
    Customer getCustomer(String[] strArray);
    ArrayList<String[]> getAllCustomer() throws IOException;
    Customer getById(int id) throws IOException;
    int modifyCustomer(Customer customer) throws IOException;
    int createCustomer(Customer customer) throws IOException;
}
