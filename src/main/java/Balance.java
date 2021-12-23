public class Balance {

    private double balance;

    public Balance(double amount) {
        balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void add(Deposit amountToDeposit) {
        balance += amountToDeposit.getValue();
    }

    public void subtract(double amountToWithdraw) {
        balance -= amountToWithdraw;
    }
}
