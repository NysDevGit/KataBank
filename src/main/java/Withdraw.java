import java.time.LocalDateTime;
import java.util.Objects;

public class Withdraw extends Transaction {

    public Withdraw(LocalDateTime dateTime, double value) {
        super(dateTime, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdraw withdraw = (Withdraw) o;
        return Double.compare(withdraw.value, value) == 0 && Objects.equals(dateTime, withdraw.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, value);
    }
}
