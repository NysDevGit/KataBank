import java.time.LocalDateTime;

public class Deposit {

    public LocalDateTime dateTime;
    public double amount;
    public double balance;

    public Deposit(LocalDateTime dateTime, double amountToDeposit, double balance) {
        this.dateTime = dateTime;
        this.amount = amountToDeposit;
        this.balance = balance;
    }
}
