package evaluationscalendar;
import dataStructures.*;

public abstract class PersonClass implements Person {
	private String name;
	private int numCourses;
	protected Array<Courses> courses;
	
	public PersonClass(String name) {
		this.name = name;
		this.numCourses = 0;
		this.courses = new ArrayClass<>();
	}		
	
	public String getName() {
		return this.name;
	}
	
	public int getNumOfCourses() {
		return this.numCourses;
	}
	
	public void addCourse(Courses course) {
		this.numCourses++;
		this.courses.insertLast(course);
	}
	
	public Iterator<Courses> getListOfCoursesInPerson() {
		return this.courses.iterator();
	}
}
