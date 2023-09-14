package bank.service;

import java.util.Collection;
import bank.domain.Account;
import bank.dto.AccountDto;

public interface IAccountService {
    AccountDto createAccount(long accountNumber, String customerName);
    AccountDto getAccount(long accountNumber);
    Collection<AccountDto> getAllAccounts();
    void deposit (long accountNumber, double amount);
    void withdraw (long accountNumber, double amount);
    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
