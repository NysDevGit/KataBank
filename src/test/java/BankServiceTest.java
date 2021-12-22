import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
            bankService.deposit(account, amountToDeposit);

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
            bankService.deposit(account, amountToDeposit);
            bankService.deposit(account, secondAmountToDeposit);

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

            //When
            bankService.withdraw(account, amountToWithdraw);

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

            //When
            bankService.withdraw(account, amountToWithdraw);
            bankService.withdraw(account, secondAmountToWithdraw);

            //Then
            Assertions.assertEquals(20.0, bankService.getAccountBalance(account));

        }
    }

    @Nested
    class TransactionHistoryTest{

        @Test
        public void should_print_one_deposit_in_history(){
            //Given
            String str = "2021-12-22 12:30";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
            double amountToDeposit = 50;
            List<Deposit> expectedTransactions = List.of(new Deposit(dateTime, amountToDeposit, amountToDeposit));
            BankService bankService = new BankService();
            Account account = new Account(new Balance(0));

            //When
            bankService.deposit(account,50);

            Assertions.assertEquals(expectedTransactions, bankService.printTransactionsHistory(account));
        }
    }


}
