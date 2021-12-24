import java.util.Comparator;
import java.util.List;

public class BankService {

    public void execute(Account account, Transaction transaction) {
        account.apply(transaction);
    }

    public double getAccountBalance(Account account) {
        return account.getCurrentBalance();
    }

    public List<Transaction> printTransactions(Account account) {
        return retrieveTransactionsSortedByDateDesc(account);
    }

    private List<Transaction> retrieveTransactionsSortedByDateDesc(Account account) {
        Comparator<Transaction> comparator = Comparator.comparing(Transaction::getDateTime).reversed();
        return account.getTransactions(comparator);
    }

}
