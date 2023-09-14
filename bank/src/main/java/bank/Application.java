package bank;

import java.util.Collection;

import bank.command.Command;
import bank.command.DepositCommand;
import bank.command.HistoryList;
import bank.command.WithdrawCommand;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;
import com.ibm.java.diagnostics.utils.commands.ICommand;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;

		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		accountService.printStatement();
		HistoryList historyList=new HistoryList();
		Command depositCommand=new DepositCommand(1263862,240,accountService);
		depositCommand.execute();

		System.out.println("After deposit 240 amount to accountNumber 1263862");
		accountService.printStatement();

		historyList.addCommand(depositCommand);
		Command withdrawCommand=new WithdrawCommand(1263862,500,accountService);
		withdrawCommand.execute();

		System.out.println("After withdraw 500 amount to accountNumber 1263862");
		accountService.printStatement();

		historyList.addCommand(withdrawCommand);

		historyList.undo();

		System.out.println("After undo");
		accountService.printStatement();


	}

}
