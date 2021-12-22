public class Balance {

    public double balance;

    public Balance(double amount) {
        balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void add(double amountToDeposit) {
        balance += amountToDeposit;
    }


}
