import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankServiceTest {

    @Nested
    class Deposit{

        @Test
        public void should_add_deposit_amount_to_current_account_balance(){
            //Given
            BankService bankService = new BankService();
            Account account = new Account(new Balance(100));
            double amountToDeposit = 50;

            //When
            bankService.deposit(account, amountToDeposit);

            //Then
            Assertions.assertEquals(150.0, bankService.getAccountBalance(account));

        }
    }
}
