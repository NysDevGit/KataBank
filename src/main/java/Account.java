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

    public void deposit(Transaction transaction) {
        balance.add(transaction.getValue());
        transactions.add(transaction);
    }

    public void withdraw(Transaction transaction) {
        balance.subtract(transaction.getValue());
        transactions.add(transaction);
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
