import java.time.LocalDateTime;

public abstract class Transaction {
    public LocalDateTime dateTime;
    public double value;

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

}
