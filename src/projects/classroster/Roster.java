package projects.classroster;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Roster {
	
	private final int MAX_NUM = 10;
	
	private final List<Student> students = new ArrayList<>();
	
	public Roster() {}
	
	public Roster(List<String> names) {
		int nextId = 1003;
		for(String name : names) students.add(new Student(name, nextId += 2));
	}
	
	public boolean containsStudent(String studentName) {
		return students.stream()
				.anyMatch(student -> student.getName().equals(studentName));
	}
	
	public String retrieveById(int id) {
		return students.stream()
				.filter(student -> student.getId() == id)
				.map(student -> student.getName())
				.findFirst().orElse(null);
	}
	
	public int retrieveId(String studentName) {
		return students.stream()
				.filter(student -> student.getName().equals(studentName))
				.mapToInt(student -> student.getId())
				.findFirst().orElse(-1);
	}
	
	public boolean addStudent(String name, int id) {
		if(students.size() >= MAX_NUM) return false;	
		
		final Student student = new Student(name, id);
		if(students.contains(student)) return false;
		else return students.add(student);
	}

	public boolean removeStudent(int id) {
		return students.removeIf(student -> student.getId() == id);
	}
	
	public boolean removeStudent(String name) {
		return students.removeIf(student -> student.getName().equals(name));
	}

	@Override
	public String toString() {
		return students.toString();
	}
	
}
