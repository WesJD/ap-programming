package projects.employee;

import static java.lang.System.out;

public class Hourly extends Employee {
	
	private static final double MONEY_PER_HOUR = 15;
	
	private final int hours;
	
	public Hourly(String name, int hours) {
		super(name);
		this.hours = hours;
	}

	public void doWork() {
		out.println("Hourly worker " + super.name + " is making stuff.");
	}
	
	public void dailyPay() {
		out.println("Hourly worker " + super.name + " is being $" + (MONEY_PER_HOUR * hours) + 
				" today for their " + hours + " hours of work.");
	}
	
}
