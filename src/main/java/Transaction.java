import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Transaction {
    private final LocalDateTime dateTime;
    private final double value;

    public Transaction(LocalDateTime dateTime, double value) {
        this.dateTime = dateTime;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.value, value) == 0 && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, value);
    }
}
