package evaluationscalendar;

public abstract class PersonClass implements Person {
	private String name;
	private int numCourses;
	
	public PersonClass(String name) {
		this.name = name;
		this.numCourses = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumOfCourses() {
		return this.numCourses;
	}
	
	
}
