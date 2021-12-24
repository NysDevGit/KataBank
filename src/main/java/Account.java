import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

    private final Balance balance;
    private final List<Transaction> transactionsHistory = new ArrayList<>();

    public Account(Balance balance) {
        this.balance = balance;
    }

    public void incrementBalance(Deposit amountToDeposit) {
        balance.add(amountToDeposit);
        transactionsHistory.add(amountToDeposit);
    }

    public void decrementBalance(Withdraw amountToWithdraw) {
        balance.subtract(amountToWithdraw.getValue());
        transactionsHistory.add(amountToWithdraw);
    }

    public double getBalance() {
        return balance.getBalance();
    }

    public List<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
