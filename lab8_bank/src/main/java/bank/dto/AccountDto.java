package bank.dto;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class AccountDto {
    long accountnumber;
    double balance;

    public AccountDto(long accountnumber, double balance, CustomerDto customer) {
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.customer = customer;
    }

    CustomerDto customer;



    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public double getBalance() {

        return balance;
    }


    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }


}
