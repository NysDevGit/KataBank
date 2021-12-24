import java.util.Comparator;
import java.util.List;

public class BankService {

    public void deposit(Account account, Deposit amountToDeposit) {
        account.incrementBalance(amountToDeposit);
    }

    public void withdraw(Account account, Withdraw amountToWithdraw) {
        account.decrementBalance(amountToWithdraw);
    }

    public double getAccountBalance(Account account) {
        return account.getBalance();
    }

    public List<Transaction> printTransactions(Account account) {
        return getTransactionsSortByDateDesc(account);
    }

    private List<Transaction> getTransactionsSortByDateDesc(Account account) {
        Comparator<Transaction> comparator = Comparator.comparing(Transaction::getDateTime).reversed();
        return account.getTransactions(comparator);
    }

}
