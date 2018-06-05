package projects.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banker {
	
	protected final String name;
	protected final List<Account> accounts = new ArrayList<>();
	
	public Banker(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public List<? extends Account> getAccounts() {
		return accounts;
	}
	
	public Optional<? extends Account> getAccount(String name) {
		return accounts.stream()
			.filter(account -> account.getName().equals(name))
			.findFirst();
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public Account getOrCreate(String name) {
		return getOrCreate(name, 0);
	}
	
	public Account getOrCreate(String name, double defaultBalance) {
		return getAccount(name)
				.orElseGet(() -> {
					final Account account = new Account(name, defaultBalance);
					addAccount(account);
					return account;
				});
	}

}
