package review;

import java.util.Scanner;

import utils.ReaderUtils;

public class LeapYearTester {
	
	private LeapYearTester() {
		final Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println();
			final int year = ReaderUtils.readFromUser(scanner, "Enter a year", (input) -> {
				final int parsed = Integer.parseInt(input);
				if(parsed < 1582) 
					throw new ReaderUtils.InvalidInput("Year too low");
				else return parsed;
			});
			
			if(year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0))
				System.out.println("Year is a leap year.");
			else
				System.out.println("Year is not a leap year.");
		}
	}
	
	public static void main(String[] args) {
		new LeapYearTester();
	}

}
