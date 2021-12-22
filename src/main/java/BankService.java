public class BankService {

    public void deposit(Account account, double amountToDeposit) {
        account.incrementBalance(amountToDeposit);
    }

    public void withdraw(Account account, double amountToWithdraw) {
        account.decrementBalance(amountToWithdraw);
    }

    public double getAccountBalance(Account account) {
        return account.getBalance();
    }

}
