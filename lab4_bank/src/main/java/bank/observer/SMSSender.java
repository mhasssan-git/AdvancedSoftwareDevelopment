package bank.observer;

import bank.service.AccountService;
import bank.service.IAccountService;

public class SMSSender extends ChangeObserver{
    public SMSSender(IAccountService accountService) {
        super(accountService);
    }

    @Override
    public void update() {
        System.out.println("Notified from SMSSender");
    }
}
