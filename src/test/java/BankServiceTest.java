import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankServiceTest {

    @Nested
    class DepositTest {

        @Test
        public void should_add_amount_to_current_account_balance() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account(new Balance(100));
            double amountToDeposit = 50;

            //When
            bankService.deposit(account, new Deposit(generateDate("2021-12-22 12:30"), amountToDeposit));

            //Then
            Assertions.assertEquals(150.0, bankService.getAccountBalance(account));

        }

        @Test
        public void should_add_severals_amount_to_current_account_balance() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account(new Balance(20));
            double amountToDeposit = 50;
            double secondAmountToDeposit = 130;

            //When
            bankService.deposit(account, new Deposit(generateDate("2021-12-22 12:30"), amountToDeposit));
            bankService.deposit(account, new Deposit(generateDate("2021-12-22 12:30"), secondAmountToDeposit));

            //Then
            Assertions.assertEquals(200.0, bankService.getAccountBalance(account));

        }
    }

    @Nested
    class WithdrawTest {
        @Test
        public void should_subtract_amount_to_current_account_balance() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account(new Balance(100));
            double amountToWithdraw = 50;
            LocalDateTime dateTime = generateDate("2021-12-22 12:30");

            //When
            bankService.withdraw(account, new Withdraw(dateTime, amountToWithdraw));

            //Then
            Assertions.assertEquals(50.0, bankService.getAccountBalance(account));
        }

        @Test
        public void should_subtract_severals_amount_to_current_account_balance() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account(new Balance(200));
            double amountToWithdraw = 50;
            double secondAmountToWithdraw = 130;
            LocalDateTime dateTime = generateDate("2021-12-22 12:30");

            //When
            bankService.withdraw(account, new Withdraw(dateTime, amountToWithdraw));
            bankService.withdraw(account, new Withdraw(dateTime, secondAmountToWithdraw));

            //Then
            Assertions.assertEquals(20.0, bankService.getAccountBalance(account));

        }
    }

    @Nested
    class TransactionHistoryTest {

        @Test
        public void should_print_one_deposit_in_history() {
            //Given
            LocalDateTime dateTime = generateDate("2021-12-22 12:30");
            double amountToDeposit = 50;
            List<Deposit> expectedTransactions = List.of(new Deposit(dateTime, amountToDeposit));
            BankService bankService = new BankService();
            Account account = new Account(new Balance(0));

            //When
            bankService.deposit(account, new Deposit(dateTime, amountToDeposit));

            Assertions.assertEquals(expectedTransactions, bankService.printTransactionsHistory(account));
        }

        @Test
        public void should_print_one_withdraw_in_history() {
            //Given
            LocalDateTime dateTime = generateDate("2021-12-22 12:30");
            double amountToWithdraw = 50;
            List<Withdraw> expectedTransactions = List.of(new Withdraw(dateTime, amountToWithdraw));
            BankService bankService = new BankService();
            Account account = new Account(new Balance(100));

            //When
            bankService.withdraw(account, new Withdraw(dateTime, amountToWithdraw));

            //Then
            Assertions.assertEquals(expectedTransactions, bankService.printTransactionsHistory(account));
        }

        @Test
        public void should_print_several_transactions_descending_order_in_history() {
            //Given
            Withdraw withdraw = new Withdraw(generateDate("2021-12-06 12:30"), 200);
            Withdraw withdraw2 = new Withdraw(generateDate("2021-12-09 12:30"), 40);
            Withdraw withdraw3 = new Withdraw(generateDate("2021-12-22 12:30"), 30);
            Deposit deposit = new Deposit(generateDate("2021-12-05 12:30"), 50);
            Deposit deposit2 = new Deposit(generateDate("2021-12-10 12:30"), 200);

            List<Transaction> expectedTransactions = List.of(
                    withdraw3, deposit2, withdraw2, withdraw, deposit);

            BankService bankService = new BankService();
            Account account = new Account(new Balance(100));

            //When
            bankService.withdraw(account, withdraw3);
            bankService.deposit(account, deposit2);
            bankService.withdraw(account, withdraw2);
            bankService.withdraw(account, withdraw);
            bankService.deposit(account, deposit);

            //Then
            Assertions.assertEquals(expectedTransactions, bankService.printTransactionsHistory(account));
        }

    }

    private LocalDateTime generateDate(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(str, formatter);
    }


}
