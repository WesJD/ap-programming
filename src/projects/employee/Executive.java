package projects.employee;

import static java.lang.System.out;

public class Executive extends Employee {
	
	public Executive(String name) {
		super(name);
	}
	
	public void doWork() {
		out.println("Executive " + super.name + " is doing an inspiring pep talk.");
	}
	
	public void dailyPay() {
		out.println("Executive " + super.name + " is being paid $2,000 for the day.");
	}

}
