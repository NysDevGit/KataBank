import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Account {

    private final List<Transaction> transactions = new ArrayList<>();

    public Account(){
    }

    public void apply(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getCurrentBalance() {
    return transactions.stream()
                 .map(Transaction::getValue)
                 .reduce((double) 0, Double::sum);
    }

    public List<Transaction> getTransactions(Comparator<Transaction> comparator) {
        return transactions.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(transactions, account.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }
}
