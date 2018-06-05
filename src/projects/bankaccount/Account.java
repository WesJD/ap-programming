package projects.bankaccount;

public class Account implements Comparable<Account> {
	
	private final String name;
	private double balance;
	
	public Account() {
		this.name = "Guest";
		this.balance = 0;
	}
	
	public Account(String owner, double balance) {
		this.name = owner;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance)  {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Account) {
			final Account account = (Account) other;
			return account.name.equals(name) && account.balance == balance;
		} else return super.equals(other);
	}

	@Override
	public int compareTo(Account other) {
		if(equals(other)) return 0;
		else if(getBalance() < other.getBalance()) return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return name + " - $" + balance;
	}
	
}
