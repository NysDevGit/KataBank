public class BankService {

    public void deposit(Account account, double amountToDeposit) {
        account.incrementBalance(amountToDeposit);
    }

    public double getAccountBalance(Account account) {
        return 0;
    }
}
