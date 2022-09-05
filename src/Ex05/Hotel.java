package Ex05;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final List<Customer> customers;

    public Hotel() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean deleteById(String id) {
        return customers.removeIf(customer -> customer.getId().equals(id));
    }

    public int calculate(String id) {
        Customer customer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
        return customer.getRoomType().getPrice() * customer.getBookingPeriod();
    }

    public void printCustomers() {
        customers.forEach(System.out::println);
    }
}
