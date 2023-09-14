package bank.service;

import java.util.Collection;

import bank.adapter.AccountAdapter;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.dto.AccountDto;
import bank.proxy.LoggingProxy;
import bank.proxy.StopWatchProxy;

import java.lang.reflect.Proxy;

public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	ClassLoader classLoader;
	IAccountDAO stopwatchProxy;
	IAccountDAO loggingProxy;
	AccountAdapter adapter=new AccountAdapter();
	public AccountService(){
		accountDAO=new AccountDAO();
		classLoader=accountDAO.getClass().getClassLoader();
		loggingProxy=(IAccountDAO)Proxy.newProxyInstance(classLoader,new Class[]{IAccountDAO.class},
				new LoggingProxy(accountDAO));
		stopwatchProxy=(IAccountDAO)Proxy.newProxyInstance(classLoader,new Class[]{IAccountDAO.class},
				new StopWatchProxy(loggingProxy));



	}

	public AccountDto createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		stopwatchProxy.saveAccount(account);
		return adapter.getAccountDTO(account);
	}

	public void deposit(long accountNumber, double amount) {
		Account account = stopwatchProxy.loadAccount(accountNumber);
		account.deposit(amount);
		stopwatchProxy.updateAccount(account);
	}

	public AccountDto getAccount(long accountNumber) {
		Account account = stopwatchProxy.loadAccount(accountNumber);
		return adapter.getAccountDTO(account);
	}

	public Collection<AccountDto> getAllAccounts() {
		return adapter.getAccountDTOs(loggingProxy.getAccounts());
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = stopwatchProxy.loadAccount(accountNumber);
		account.withdraw(amount);
		stopwatchProxy.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = stopwatchProxy.loadAccount(fromAccountNumber);
		Account toAccount = stopwatchProxy.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		stopwatchProxy.updateAccount(fromAccount);
		stopwatchProxy.updateAccount(toAccount);
	}
}
