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
        public void should_return_current_balance_after_one_deposit() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account();

            //When
            bankService.execute(account, new Transaction(generateDate("2021-12-22 12:30"), 50, Operation.DEPOSIT));

            //Then
            Assertions.assertEquals(50.0, bankService.getAccountBalance(account));

        }

        @Test
        public void should_return_current_balance_after_several_deposit() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account();

            //When
            bankService.execute(account, new Transaction(generateDate("2021-12-22 12:30"), 50, Operation.DEPOSIT));
            bankService.execute(account, new Transaction(generateDate("2021-12-22 12:30"), 130, Operation.DEPOSIT));

            //Then
            Assertions.assertEquals(180.0, bankService.getAccountBalance(account));

        }
    }

    @Nested
    class WithdrawTest {
        @Test
        public void should_return_current_balance_after_one_withdraw() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account();
            LocalDateTime dateTime = generateDate("2021-12-22 12:30");

            //When
            bankService.execute(account, new Transaction(dateTime, 50, Operation.WITHDRAW));

            //Then
            Assertions.assertEquals(-50.0, bankService.getAccountBalance(account));
        }

        @Test
        public void should_return_current_balance_after_several_withdraw() {
            //Given
            BankService bankService = new BankService();
            Account account = new Account();
            LocalDateTime dateTime = generateDate("2021-12-12 12:30");

            //When
            bankService.execute(account, new Transaction(dateTime, 50, Operation.WITHDRAW));
            bankService.execute(account, new Transaction(dateTime, 130, Operation.WITHDRAW));

            //Then
            Assertions.assertEquals(-180.0, bankService.getAccountBalance(account));

        }
    }

    @Nested
    class TransactionsTest {

        @Test
        public void should_print_one_deposit_in_transactions_statement() {
            //Given
            LocalDateTime dateTime = generateDate("2021-12-22 08:30");
            double amountToDeposit = 50;
            List<Transaction> expectedTransactions = List.of(new Transaction(dateTime, amountToDeposit, Operation.DEPOSIT));
            BankService bankService = new BankService();
            Account account = new Account();

            //When
            bankService.execute(account, new Transaction(dateTime, amountToDeposit, Operation.DEPOSIT));

            Assertions.assertEquals(expectedTransactions, bankService.printTransactions(account));
        }

        @Test
        public void should_print_one_withdraw_in_transactions_statement() {
            //Given
            LocalDateTime dateTime = generateDate("2021-12-22 12:30");
            double amountToWithdraw = 50;
            List<Transaction> expectedTransactions = List.of(new Transaction(dateTime, amountToWithdraw, Operation.DEPOSIT));
            BankService bankService = new BankService();
            Account account = new Account();

            //When
            bankService.execute(account, new Transaction(dateTime, amountToWithdraw, Operation.DEPOSIT));

            //Then
            Assertions.assertEquals(expectedTransactions, bankService.printTransactions(account));
        }

        @Test
        public void should_print_several_transactions_descending_order_in_transactions_statement() {
            //Given
            Transaction withdraw = new Transaction(generateDate("2021-12-06 12:30"), 200, Operation.WITHDRAW);
            Transaction withdraw2 = new Transaction(generateDate("2021-12-09 12:30"), 40, Operation.WITHDRAW);
            Transaction withdraw3 = new Transaction(generateDate("2021-12-22 12:30"), 30, Operation.WITHDRAW);
            Transaction deposit = new Transaction(generateDate("2021-12-05 12:30"), 50, Operation.DEPOSIT);
            Transaction deposit2 = new Transaction(generateDate("2021-12-10 12:30"), 200, Operation.DEPOSIT);

            List<Transaction> expectedTransactions = List.of(
                    withdraw3, deposit2, withdraw2, withdraw, deposit);

            BankService bankService = new BankService();
            Account account = new Account();

            //When
            bankService.execute(account, withdraw3);
            bankService.execute(account, deposit2);
            bankService.execute(account, withdraw2);
            bankService.execute(account, withdraw);
            bankService.execute(account, deposit);

            //Then
            Assertions.assertEquals(expectedTransactions, bankService.printTransactions(account));
        }

    }

    private LocalDateTime generateDate(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}
