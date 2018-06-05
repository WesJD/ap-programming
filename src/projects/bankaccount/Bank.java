package projects.bankaccount;

import java.util.Date;

import static java.lang.System.out;

public class Bank {
	
	private Bank() {
		final PersistentBanker banker = new PersistentBanker("Wesley", "H:\\banker-" + new Date().getDate());
		
		Account account = banker.getAccount("Savings")
				.orElseGet(() -> {
					final Account newAccount = new Account("Savings", 0);
					banker.addAccount(newAccount);
					return newAccount;
				});
		showCurrentBalance(account);
		deposit(account, 1000);
		withdraw(account, 500);
		deposit(account, 230);
		withdraw(account, 45);
		deposit(account, 150);
		
		banker.saveAccounts();
	}
	
	private void showCurrentBalance(Account account) {
		out.println("Current balance is: $" + account.getBalance());
	}
	
	private void withdraw(Account account, double amount) {
		out.println("Withdrawing $" + amount + "...");
		account.withdraw(amount);
		showCurrentBalance(account);
	}
	
	private void deposit(Account account, double amount) {
		out.println("Depositing $" + amount + "...");
		account.deposit(amount);
		showCurrentBalance(account);
	}
	
	public static void main(String[] args) {
		new Bank();
	}

}
