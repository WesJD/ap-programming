package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Statistics {
	
	private Statistics() {
		final List<Integer> numbers = new ArrayList<>();
		try(Scanner scanner = new Scanner(new File("numbers.txt"))) {
			while(scanner.hasNext()) numbers.add(scanner.nextInt());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	
		final double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(-1);
		System.out.println("Average: " + average);
		
		int sumOfDeltas = 0;
		
		int mostCommon = -1;
		int count = 0;
		for(int value : numbers) {
			int localCount = 0;
			for(int local : numbers) if(local == value) localCount++;
			
			if(localCount > count) {
				count = localCount;
				mostCommon = value;
			}
			
			sumOfDeltas += Math.pow(Math.abs(average - value), 2);
		}
		System.out.println("Mode: " + mostCommon);
		
		final double deviation = Math.sqrt(sumOfDeltas / numbers.size() - 1);
		System.out.println("Deviation: " + deviation);
	}
	
	public static void main(String[] args) {
		new Statistics();
	}

}
