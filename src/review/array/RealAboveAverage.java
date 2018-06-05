package review.array;

import java.util.Arrays;
import java.util.Scanner;

public class RealAboveAverage {

	public static void main(String[] args) {
		System.out.println("please input a number between 1~10");
		int n;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();

		final int[] mArray = new int[n];

		fillArray(input, mArray);
		printArray(mArray);
		String[] grade = processArray(mArray);
		printArray(grade);

	}

	// Ask user for input of scores
	public static void fillArray(Scanner scanner, int[] input) {
		for(int i=0; i < input.length; i++) {
			System.out.println("What is value " + (i+1) + "?");
			input[i] = scanner.nextInt();
		}
	}

	// output scores
	public static void printArray(int[] input) {
		// implementation below
		System.out.println(Arrays.toString(input));
	}

	// output scores
	public static void printArray(String[] input) {
		// implementation below
		Arrays.stream(input)
			.forEach(System.out::println);
	}

	// find the average, then create a new array to store comparison if each
	// item is above or below average
	public static String[] processArray(int[] input) {
		// implementation below
		final double average = Arrays.stream(input).average().orElse(-1);
		return Arrays.stream(input)
				.mapToObj((value) -> {
					if(value >= average) return "Grade " + value + " is above average";
					else return "Grade " + value + " is below average";
				})
				.toArray((size) -> new String[size]);
	}

}
