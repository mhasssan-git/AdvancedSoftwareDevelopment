package bank.factory;

import bank.dao.IAccountDAO;
import bank.dao.MockAccountDAO;
import bank.singleton.IEmailSender;
import bank.singleton.MockEmailSender;

public class MockFactory implements IFactory {
    @Override
    public IAccountDAO getAccountDao() {
        return new MockAccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return  MockEmailSender.getSender();
    }
}
