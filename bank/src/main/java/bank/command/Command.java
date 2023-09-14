package bank.command;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.service.AccountService;
import bank.service.IAccountService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class Command {
    IAccountService accountService;
    long accountNumber;
    double amount;

    public Command(long accountNumber, double amount,IAccountService accountService) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.accountService=accountService;
    }

    public abstract void execute();
    public  void unExecute(){
    Optional<Account> oAccount= accountService.getAllAccounts().stream().
        filter(t->t.getAccountnumber()==accountNumber).findFirst();
    if(oAccount.isPresent())
    {
        Account account=oAccount.get();
        ArrayList<AccountEntry> entries=(ArrayList<AccountEntry>) account.getEntryList();
        entries.remove(entries.size()-1);
        entries.remove(entries.size()-1);
    }
    }
}
