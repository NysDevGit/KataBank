public class Balance {

    private double balance;

    public Balance(double amount) {
        balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void add(double amountToDeposit) {
        balance += amountToDeposit;
    }

    public void subtract(double amountToWithdraw) {
        balance -= amountToWithdraw;
    }
}
