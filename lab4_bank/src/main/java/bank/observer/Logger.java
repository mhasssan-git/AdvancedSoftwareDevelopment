package bank.observer;

import bank.service.AccountService;
import bank.service.IAccountService;

public class Logger extends ChangeObserver {
    public Logger(IAccountService accountService) {
        super(accountService);
    }

    @Override
    public void update() {
        System.out.println("Notified from logger");
    }
}
