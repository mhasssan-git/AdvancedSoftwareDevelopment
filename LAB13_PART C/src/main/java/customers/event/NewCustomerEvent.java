package customers.event;

import customers.Customer;

public class NewCustomerEvent {
    public NewCustomerEvent(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    Customer customer;
}
