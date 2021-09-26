
@SuppressWarnings("serial")
public class NotEnoughFundsException extends RuntimeException {
	
	public NotEnoughFundsException(int balance,int amount) {
		super("Attempted to withdraw " + amount + " with a balance of " + balance);
	}

}
