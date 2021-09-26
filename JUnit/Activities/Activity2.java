import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Activity2 {
	
	@Test
	public void enoughFunds() {
		BankAccount accountObj = new BankAccount(100);
		assertDoesNotThrow(() -> accountObj.withdrawal(90));
	}
	
	
	@Test
	public void notEnoughFunds() {
		BankAccount accountObj = new BankAccount(9);
		assertThrows(NotEnoughFundsException.class, () -> accountObj.withdrawal(10));
	}
	
}
