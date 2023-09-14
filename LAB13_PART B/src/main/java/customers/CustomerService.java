package customers;

import customers.event.NewCustomerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Autowired
    public void setEmailSender(IEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Autowired
    private ApplicationEventPublisher publisher;

    ICustomerDAO customerDAO;
    IEmailSender emailSender;

    public void addCustomer(String name, String email, String street,
                            String city, String zip) {
        Customer customer = new Customer(name, email);
        Address address = new Address(street, city, zip);
        customer.setAddress(address);
        customerDAO.save(customer);
        emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
        publisher.publishEvent(new NewCustomerEvent(customer));
    }
}
