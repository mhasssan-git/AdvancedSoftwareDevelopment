package bank.command;

import bank.service.IAccountService;

public class DepositCommand extends Command {

    public DepositCommand(long accountNumber, double amount, IAccountService accountService) {
        super(accountNumber, amount,accountService);
    }

    @Override
    public void execute() {
        accountService.deposit(accountNumber,amount);
    }

    @Override
    public void unExecute() {
        accountService.withdraw(accountNumber,amount);
        super.unExecute();
    }
}
