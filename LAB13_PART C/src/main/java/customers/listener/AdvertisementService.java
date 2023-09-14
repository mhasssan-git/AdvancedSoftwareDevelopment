package customers.listener;

import customers.Customer;
import customers.event.NewCustomerEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class AdvertisementService {
    @EventListener
    @Async
    public void onEvent(NewCustomerEvent event) {
        Customer customer = event.getCustomer();
        System.out.printf("From AdvertisementService, Customer Name: %s ," +
                        "address: %s, " +
                        "email: %s\n"
                ,customer.getName()
        ,customer.getAddress().toString()
        ,customer.getEmail());
    }
}
