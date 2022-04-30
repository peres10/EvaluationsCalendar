package evaluationscalendar;

import dataStructures.Iterator;

/**
 * A person that has a name and the number of courses enrolled/assigned in
 */
public interface Person {
	/**
	 * Gets the name of a person
	 * @return String with name of a person
	 */
	String getName();

	/**
	 * Gets number of courses a person is enrolled/assigned in
	 * @return int with the number of courses
	 */
	int getNumOfCourses();

	/**
	 * Increases the number of courses a Person is enrolled/assigned
	 * @param courses 
	 */
	void addCourse(Courses courses);
	
	/**
	 * 
	 * @return
	 */
	Iterator<Courses> getListOfCoursesInPerson();
}
