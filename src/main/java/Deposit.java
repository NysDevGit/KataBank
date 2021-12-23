import java.time.LocalDateTime;
import java.util.Objects;

public class Deposit extends Transaction{

    public Deposit(LocalDateTime dateTime, double value) {
        super(dateTime,value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Double.compare(deposit.value, value) == 0 && Objects.equals(dateTime, deposit.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, value);
    }
}
