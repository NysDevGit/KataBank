public class Account {

    public Balance balance;

    public Account(Balance balance) {
        this.balance = balance;
    }

    public void incrementBalance(double amountToDeposit) {
        balance.add(amountToDeposit);
    }
}
