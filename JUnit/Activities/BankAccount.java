
public class BankAccount {
	
	private int balance;
	
	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	public int withdrawal(int amount) throws NotEnoughFundsException {
		if(balance<amount) {
			throw new NotEnoughFundsException(balance,amount);
		}else
			balance-=amount;
		return balance;
	}
	
}
