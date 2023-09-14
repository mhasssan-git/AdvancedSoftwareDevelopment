package bank.observer;

import bank.service.AccountService;
import bank.service.IAccountService;

public abstract class ChangeObserver extends Observer{
    public ChangeObserver(IAccountService accountService) {
        super(accountService);
    }
}
