package bank.adapter;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.dto.AccountDto;
import bank.dto.CustomerDto;

import java.util.ArrayList;
import java.util.Collection;

public class AccountAdapter {
    public AccountDto getAccountDTO(Account account) {
        CustomerAdapter customerAdapter = new CustomerAdapter();
        CustomerDto customerDto = customerAdapter.getCustomerDTO(account.getCustomer());
        return new AccountDto(account.getAccountnumber(), account.getBalance(), customerDto);
    }

    public Collection<AccountDto> getAccountDTOs(Collection<Account> account) {

        Collection<AccountDto> dtos = new ArrayList<>();
        account.forEach(t -> dtos.add(getAccountDTO(t)));
        return dtos;
    }
}
