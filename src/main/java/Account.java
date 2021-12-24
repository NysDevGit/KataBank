import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Account {

    private final Balance balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(Balance balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions(Comparator<Transaction> comparator) {
        return transactions.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public void incrementBalance(Deposit amountToDeposit) {
        balance.add(amountToDeposit);
        transactions.add(amountToDeposit);
    }

    public void decrementBalance(Withdraw amountToWithdraw) {
        balance.subtract(amountToWithdraw.getValue());
        transactions.add(amountToWithdraw);
    }

    public double getBalance() {
        return balance.getBalance();
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
