package review;

import java.util.Scanner;

import utils.ReaderUtils;

import static java.lang.System.out;

public class Factorial {
	
	private Factorial() {
		final Scanner scanner = new Scanner(System.in);
		final int toFind = ReaderUtils.readFromUser(scanner, "Enter a number to find the factorial of",
							(input) -> {
								final int parsed = Integer.parseInt(input);
								if(parsed < 0) throw new ReaderUtils.InvalidInput("Number cannot be negative!");
								return parsed;
							});
		
		int total = (toFind == 0 ? 1 : toFind);
		for(int i=(total-1); i > 1; i--) total *= i;
		out.println(toFind + "! = " + total);
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		new Factorial();
	}

}
