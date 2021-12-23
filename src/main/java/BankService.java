import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Transaction> printTransactionsHistory(Account account) {
        return getTransactionHistoryDescOrdered(account);
    }

    private List<Transaction> getTransactionHistoryDescOrdered(Account account) {
        return account.transactionsHistory.stream()
                .sorted(Comparator.comparing(Transaction::getDateTime).reversed()
        ).collect(Collectors.toList());
    }
}
