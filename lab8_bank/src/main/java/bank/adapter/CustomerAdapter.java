package bank.adapter;

import bank.domain.Customer;
import bank.dto.CustomerDto;

public class  CustomerAdapter {
    public CustomerDto getCustomerDTO(Customer customer)
    {
        return new CustomerDto(customer.getName());
    }
}
