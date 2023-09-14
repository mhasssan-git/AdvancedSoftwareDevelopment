package bank.adapter;

import bank.domain.AccountEntry;
import bank.dto.AccountEntryDto;

public class AccountEntryAdapter {
    public AccountEntryDto getAccountEntryDto(AccountEntry accountEntry) {
        return new AccountEntryDto(accountEntry.getDate(),
                accountEntry.getAmount(), accountEntry.getDescription(),accountEntry.getFromAccountNumber()
        ,accountEntry.getFromPersonName());
    }
}
