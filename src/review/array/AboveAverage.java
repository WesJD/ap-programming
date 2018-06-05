package review.array;

import java.util.Arrays;
import java.util.Scanner;

import utils.ReaderUtils;
import static java.lang.System.out;

public class AboveAverage {
	
	private AboveAverage() {
		try(Scanner scanner = new Scanner(System.in)) {
			final int[] values = ReaderUtils.readFromUser(scanner, "How many grades do you have?", 
					(input) -> new int[Integer.parseInt(input)]);
			
			for(int i=0; i < values.length; i++) 
				values[i] = ReaderUtils.readFromUser(scanner, "Enter value " + (i+1), Integer::parseInt);
			
			out.println("Values you inputted: " + Arrays.toString(values));
			
			final double average = Arrays.stream(values).average().orElse(-1);
			out.println("Your average: " + average);
			Arrays.stream(values)
				.mapToObj((value) -> {
					if(value >= average) return "Grade " + value + " is above average.";
					else return "Grade " + value + " is below average";
				})
				.forEach(out::println);
		}
	}
	
	public static void main(String[] args) {
		new AboveAverage();
	}

}