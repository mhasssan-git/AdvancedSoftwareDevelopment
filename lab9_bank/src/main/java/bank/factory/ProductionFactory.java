package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.singleton.EmailSender;
import bank.singleton.IEmailSender;

public class ProductionFactory implements IFactory {
    @Override
    public IAccountDAO getAccountDao() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return EmailSender.getSender();
    }
}
