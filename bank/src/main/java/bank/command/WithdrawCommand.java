package bank.command;

import bank.service.IAccountService;

public class WithdrawCommand extends Command {
    public WithdrawCommand(long accountNumber, double amount, IAccountService accountService) {
        super(accountNumber, amount,accountService);
    }

    @Override
    public void execute() {
        accountService.withdraw(accountNumber, amount);
    }

    @Override
    public void unExecute() {
        accountService.deposit(accountNumber, amount);
        super.unExecute();

    }
}
