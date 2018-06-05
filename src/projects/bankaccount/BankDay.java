package projects.bankaccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class BankDay {
	
	private BankDay() {
		final Banker banker = new Banker("System");
		
		try(Scanner scanner = new Scanner(new File("bank_account_saving_checking.txt"))){
			final Pattern pattern = Pattern.compile("(.+)\\t+(\\d+)\\t+(\\d+\\.?\\d+)?\\t+?");
			while(scanner.hasNextLine()) {
				final Matcher match = pattern.matcher(scanner.nextLine());
				if(match.matches()) {
					final String name = match.group(1);
					final double balance = Double.parseDouble(match.group(2));
					
					final Account adding;
					final String modifierValue = match.group(3);
					if(modifierValue != null) {
						final double modifier = Double.parseDouble(modifierValue);
						if(modifier >= 1) adding = new CheckingAccount(name, balance, modifier);
						else adding = new SavingsAccount(name, balance, modifier);
					} else adding = new Account(name, balance);
					
					banker.addAccount(adding);
				} else throw new RuntimeException("Malformed file data.");
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		banker.getAccount("Addison").ifPresent(account -> {
			account.withdraw(100);
			account.deposit(50);
			out.println(account);
		});
		
		banker.getAccount("Albert").ifPresent(account -> {
			if(account instanceof SavingsAccount) {
				for(int i=0; i < 3; i++) account.withdraw(200);
				account.deposit(1000);
				((SavingsAccount) account).calculateInterest();
				
				out.println(account);
			} else throw new RuntimeException("Couldn't find correct Albert account.");
		});
		
		banker.getAccount("Adonis").ifPresent(account -> account.deposit(5));
		
		out.println();
		out.println("All accounts:");
		banker.getAccounts().forEach(out::println);
	}
	
	public static void main(String[] args) {
		new BankDay();
	}

}
