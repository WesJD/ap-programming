package projects.employee;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Company {
	
	private Company() {
		final List<StaffMember> staffMembers = Arrays.asList(
				new Volunteer(),
				new Hourly("John", 8),
				new Executive("Peter"),
				new Hourly("Jack", 6));
		
		out.println("The company is working...");
		staffMembers.forEach(StaffMember::doWork);
		
		out.println();
		out.println("The company is being paid for the day...");
		staffMembers.forEach(StaffMember::dailyPay);
	}
	
	public static void main(String[] args) {
		new Company();
	}

}
