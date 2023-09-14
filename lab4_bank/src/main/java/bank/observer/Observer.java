package bank.observer;

import bank.service.AccountService;
import bank.service.IAccountService;

public abstract class Observer {
    protected IAccountService accountService;

    public Observer(IAccountService accountService) {
        this.accountService = accountService;
    }
    public abstract void update();
}
