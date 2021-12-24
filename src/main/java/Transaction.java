import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private final LocalDateTime dateTime;
    private final double value;
    private final Operation type;

    public Transaction(LocalDateTime dateTime, double value, Operation type) {
        this.dateTime = dateTime;
        this.value = value;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Operation getType() {
        return type;
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
