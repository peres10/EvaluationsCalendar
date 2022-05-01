package evaluationscalendar;

import dataStructures.Iterator;

/**
 * A person that has a name and the number of courses enrolled/assigned in
 */
public interface Person {

	/*
	 ****************************************** Setters ******************************************
	 */

	/**
	 * Adds a course to the list of courses of a Person
	 * @param courses
	 */
	void addCourse(Courses course);


	/*
	 ****************************************** Getters ******************************************
	 */

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


	/*
	 ****************************************** Iterators & Array's ******************************************
	 */

	/**
	 * Gets the list of Courses that a person is in
	 * @return Iterator of Courses
	 */
	Iterator<Courses> getListOfCoursesInPerson();
}
