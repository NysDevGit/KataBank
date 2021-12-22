import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankServiceTest {

    @Nested
    class DepositTest{

        @Test
        public void should_add_amount_to_current_account_balance(){
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
        public void should_add_severals_amount_to_current_account_balance(){
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

}
