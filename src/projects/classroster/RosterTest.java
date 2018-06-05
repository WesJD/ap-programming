package projects.classroster;

import java.util.Arrays;

import static java.lang.System.out;

public class RosterTest {
	
	public static void main(String[] args) {
		final Roster roster = new Roster(Arrays.asList("Jack", "Jane", "Janet", "Jasmin"));
		out.println(roster);
		
		roster.addStudent("Jessie", 1017);
		out.println(roster);
		
		roster.removeStudent("Jane");
		out.println(roster);
		
		roster.removeStudent(1011);
		out.println(roster);
		
		out.println("name of student with id 1011: " + roster.retrieveById(1011));
		out.println("student Jessie has id: " + roster.retrieveId("Jessie"));
		out.println(roster);
	}

}
