import java.util.Comparator;
import java.util.List;

public class BankService {

    public void compute(Account account, Transaction transaction) {
        if(Operation.DEPOSIT.equals(transaction.getType()))
            account.deposit(transaction);
        else account.withdraw(transaction);
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
