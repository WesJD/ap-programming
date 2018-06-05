package projects.classroster;

public class Student {
	
	private final String name;
	private final int id;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			final Student other = (Student) obj;
			return other.id == id && other.name.equals(name);
		} else return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Student{name=" + name + ", id=" + id + "}";
	}
}
