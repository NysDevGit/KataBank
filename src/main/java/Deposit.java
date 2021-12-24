import java.time.LocalDateTime;

public class Deposit extends Transaction{

    public Deposit(LocalDateTime dateTime, double value) {
        super(dateTime,value);
    }

}
