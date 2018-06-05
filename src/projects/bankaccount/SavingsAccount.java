package projects.bankaccount;

public class SavingsAccount extends Account {
	
	private static final int TRANSACTIONS_WARNING = 3;

	private final double interestRate;
	private int transactions = 0;
	
	public SavingsAccount(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public SavingsAccount(String owner, double balance, double interestRate) {
		super(owner, balance);
		this.interestRate = interestRate;
	}
	
	private void checkTransactions() {
		if(transactions >= TRANSACTIONS_WARNING) 
			System.out.println("You have reached the transaction warning! (" + TRANSACTIONS_WARNING + ")");
	}
	
	public void resetTransactions() {
		transactions = 0;
	}
	
	public void calculateInterest() {
		super.deposit(super.getBalance() * interestRate);
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		transactions++;
		checkTransactions();
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		transactions++;
		checkTransactions();
	}
	
	@Override
	public String toString() {
		return super.toString() + " with " + transactions + " total transactions (interest rate: " + interestRate + ")";
	}
	
}
