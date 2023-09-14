package bank.observer;

import bank.service.AccountService;
import bank.service.IAccountService;

public abstract class CreateObserver extends Observer {
    public CreateObserver(IAccountService accountService) {
        super(accountService);
    }
}
