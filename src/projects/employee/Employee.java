package projects.employee;

public abstract class Employee implements StaffMember {

	protected final String name;
	
	public Employee(String name) {
		this.name = name;
	}
	
}
