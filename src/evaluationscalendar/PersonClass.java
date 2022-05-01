package evaluationscalendar;
import dataStructures.*;

/**
 * A person that has a name and the number of courses enrolled/assigned in
 */
public abstract class PersonClass implements Person {
	private String name;
	private int numCourses;
	protected Array<Courses> courses;

	public PersonClass(String name) {
		this.name = name;
		this.numCourses = 0;
		this.courses = new ArrayClass<>();
	}


	/*
	 ****************************************** Setters ******************************************
	 */

	/*
		Adds a course to the list of courses of a Person
	 */
	public void addCourse(Courses course) {
		this.numCourses++;
		this.courses.insertLast(course);
	}

	/*
	 ****************************************** Getters ******************************************
	 */

	/*
		Gets number of courses a person is enrolled/assigned in
	 */
	public int getNumOfCourses() {
		return this.numCourses;
	}

	/*
		Gets the name of a person
	 */
	public String getName() {
		return this.name;
	}

	/*
	 ****************************************** Iterators & Array's ******************************************
	 */

	/*
		Gets the list of Courses that a person is in
	 */
	public Iterator<Courses> getListOfCoursesInPerson() {
		return this.courses.iterator();
	}
}
