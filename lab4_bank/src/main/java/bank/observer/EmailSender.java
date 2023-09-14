package bank.observer;

import bank.service.AccountService;
import bank.service.IAccountService;

public class EmailSender extends CreateObserver{
    public EmailSender(IAccountService accountService) {
        super(accountService);
    }

    @Override
    public void update() {
        System.out.println("Notified from EmailSender");
    }
}
