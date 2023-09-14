package bank.dao;

import java.util.*;
import bank.domain.Account;

public class MockAccountDAO implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountlist.add(account);
		System.out.println("Mock Account DAO save account");
	}

	public void updateAccount(Account account) {
		System.out.println("Mock Account DAO update account");
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}
	}

	public Account loadAccount(long accountnumber) {
		System.out.println("Mock Account DAO Load account");
		for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		System.out.println("Mock Account get Accounts");
		return accountlist;
	}

}
