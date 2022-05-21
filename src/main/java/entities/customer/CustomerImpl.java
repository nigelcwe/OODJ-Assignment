package entities.customer;

import entities.shared.FileSelection;
import entities.shared.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CustomerImpl implements CustomerPort {
    private final File file = new File(FileSelection.Customer.toString());
    private final TextFile tf = new TextFile();
    private ArrayList<String[]> allCustomer = tf.readAll(file);

    public CustomerImpl() throws IOException {
    }

    private void updateAllCustomer() throws IOException {
        allCustomer = tf.readAll(file);
    }

    @Override
    public int generateId() throws IOException {
        ArrayList<String[]> reverseAllCustomer = new ArrayList<>();
        reverseAllCustomer.addAll(allCustomer);
        updateAllCustomer();
        Collections.reverse(reverseAllCustomer);
        return Integer.parseInt(reverseAllCustomer.get(0)[0]) + 1;
    }

    @Override
    public Customer getCustomer(String[] strArray) {
        return new Customer(
                Integer.parseInt(strArray[0]),
                strArray[1],
                strArray[2],
                strArray[3],
                strArray[4],
                Integer.parseInt(strArray[5])
        );
    }

    @Override
    public ArrayList<String[]> getAllCustomer() {
        return allCustomer;
    }

    @Override
    public Customer getById(int id) {
        for (String[] i : allCustomer) {
            if (Integer.parseInt(i[0]) == id) {
                return getCustomer(i);
            }
        }
        return null;
    }

    @Override
    public int modifyCustomer(Customer customer) throws IOException {
        ArrayList<String[]> oldAllCustomer = new ArrayList<>();
        oldAllCustomer.addAll(allCustomer);
        updateAllCustomer();

        for (String[] i : allCustomer) {
            if (Integer.parseInt(i[0]) == customer.id) {
                i[0] = Integer.toString(customer.id);
                i[1] = customer.firstName;
                i[2] = customer.lastName;
                i[3] = customer.phoneNum;
                i[4] = customer.email;
                i[5] = Integer.toString(customer.bookingId);
                break;
            }
        }

        tf.write(file, allCustomer);

        for (int i = 0; i < oldAllCustomer.size(); i++) {
            String[] temp = oldAllCustomer.get(i);
            String[] temp2 = allCustomer.get(i);
            for (int j = 0; j < temp.length; j++) {
                if (!temp[j].equals(temp2[j])) return 0;
            }
        }
        return 1;
    }

    @Override
    public int createCustomer(Customer customer) throws IOException {
        String[] newCustomer = {
                Integer.toString(customer.id),
                customer.firstName,
                customer.lastName,
                customer.phoneNum,
                customer.email,
                Integer.toString(customer.bookingId)
        };
        tf.append(file, newCustomer);
        return 0;
    }
}
