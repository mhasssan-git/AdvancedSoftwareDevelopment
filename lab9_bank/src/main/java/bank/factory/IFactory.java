package bank.factory;

import bank.dao.IAccountDAO;
import bank.singleton.IEmailSender;

public interface IFactory {
    public IAccountDAO getAccountDao();
    public IEmailSender getEmailSender();
}
