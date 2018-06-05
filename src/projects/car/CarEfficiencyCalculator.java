package projects.car;

import java.text.DecimalFormat;
import java.util.Scanner;

import utils.ReaderUtils;
import static java.lang.System.out;

public class CarEfficiencyCalculator {
	
	private CarEfficiencyCalculator() {
		final Scanner scanner = new Scanner(System.in);
		final int initialOdometer = ReaderUtils.readFromUser(scanner, "Enter the initial odometer reading",
										Integer::parseInt);
		final Car car = new Car(initialOdometer);
		
		while(true) {
			out.println();
			out.println("---- [ FILLING STATION VISIT ] ----");
			
			final int newOdometer = ReaderUtils.readFromUser(scanner, "What is the new odometer reading?",
										Integer::parseInt);
			final double gallonsFilled = ReaderUtils.readFromUser(scanner, "How many gallons were purchased?",
											Double::parseDouble);
			car.fillUp(newOdometer, gallonsFilled);
			
			out.println();
			out.println("Miles per gallon: " + car.calculateMpg());
		}
	}
	
	public static void main(String[] args) {
		new CarEfficiencyCalculator();
	}

}
