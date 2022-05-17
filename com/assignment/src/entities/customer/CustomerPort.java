package com.assignment.src.entities.customer;

import java.io.IOException;
import java.util.ArrayList;

public interface CustomerPort {
    ArrayList<String[]> getAllCustomer();
    Customer getById(int id);
    int modifyCustomer(Customer customer) throws IOException;
    int createCustomer(Customer customer) throws IOException;
}
