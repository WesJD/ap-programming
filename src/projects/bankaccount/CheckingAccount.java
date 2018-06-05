package projects.bankaccount;

public class CheckingAccount extends Account {

	private final double transactionFee;
	
	public CheckingAccount(double transactionFee) {
		this.transactionFee = transactionFee;
	}
	
	public CheckingAccount(String name, double balance, double transactionFee){
		super(name, balance);
		this.transactionFee = transactionFee;
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount - transactionFee);
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount + transactionFee);
	}
	
	@Override
	public String toString() {
		return super.toString() + " (transaction fee: " + transactionFee + ")";
	}
	
}
