package projects.bankaccount;

import java.util.Scanner;

import utils.ReaderUtils;

import static java.lang.System.out;

public class BigBucks {
	
	private BigBucks() {
		final Banker banker = new Banker("System");
		try(Scanner scanner = new Scanner(System.in)) {
			while(true) {
				final String name = ReaderUtils.readFromUser(scanner, "Enter an individual's name or exit to calculate");
				if(name.equalsIgnoreCase("exit")) break;
				
				final double balance = ReaderUtils.readFromUser(scanner, "What is their balance?", Double::parseDouble);
				banker.getOrCreate(name).setBalance(balance);
			}
		}
		
		final String winner = banker.getAccounts()
				.stream()
				.sorted()
				.map(account -> account.getName())
				.findFirst().orElse("No one");
		out.println(winner + " has the highest balance.");
	}
	
	public static void main(String[] args) {
		new BigBucks();
	}

}
