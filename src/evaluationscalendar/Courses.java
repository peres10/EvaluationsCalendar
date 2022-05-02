package evaluationscalendar;

import dataStructures.*;
import java.time.*;


/**
 * A course with Students and Professors assigned to it, also has a list of deadlines and tests
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public interface Courses {

	/*
	****************************************** Setters ******************************************
	*/

	/**
	 * Adds a professor to the course
	 * @pre professor != null
	 * @param professor - variable of type ProfessorClass (Person that is an instance of Professor)
	 */
	void addProfessor(Person professor);

	/**
	 * Adds a student to the course
	 * @pre student != null
	 * @param student - variable of type StudentClass (Person that is an instance of Student)
	 */
	void addStudent(Person student);

	/**
	 * Adds a test to a course
	 *
	 *
	 */
	void addTest(LocalDateTime testDate,int duration,String testName,String courseName);

	/**
	 * Adds a deadline to a course
	 * @pre !hasDeadline(name)
	 * @param deadlineDate - date of the deadline
	 * @param name - name of the deadline
	 */
	void addDeadline(LocalDate deadlineDate,String name);


	/*
	****************************************** Getters ******************************************
	*/

	/**
	 * Gets the name of a course
	 * @return String with the name of the course
	 */
	String getName();

	/**
	 * Gets the number of professors of a course
	 * @return int with the number of students of the course
	 */
	int getNumberOfProfessors();

	/**
	 * Gets the number of students of a course
	 * @return int with the number of professors of the course
	 */
	int getNumberOfStudents();

	/**
	 * Gets the number of tests of a course
	 * @return int with the number of tests of the course
	 */
	int getNumberOfTests();

	/**
	 * Gets the number of deadlines of a course
	 * @return int with the number of tests of the course
	 */
	int getNumberOfDeadlines();


	/*
	****************************************** Pre-Conditions ******************************************
	*/

	/**
	 * Checks if a deadline with a specific name already exists in the course
	 * @param deadlineName
	 * @return true if exists , false if not
	 */
	boolean hasDeadline(String deadlineName);


	/*
	*************************************** Iterators & Array's ***************************************
	*/

	/**
	 * Returns the list of professors of a course
	 * @return Iterator of Person (with the professors)
	 */
	Iterator<Person> getListOfProfessorsCourse();

	/**
	 * Returns the list of students of a course
	 * @return Iterator of Person (with the students)
	 */
	Iterator<Person> getListOfStudentsCourse();

	/**
	 * Returns the array of professors in a course (array need for the intersection command)
	 * @return Array of Person (with the professors)
	 */
	Array<Person> getArrayOfProfessors();

	/**
	 * Returns the array of students in a course (array need for the intersection command)
	 * @return Array of Person (with the students)
	 */
	Array<Person> getArrayOfStudents();

	/**
	 * Returns the list of deadlines of a course
	 * @return Iterator of Deadline
	 */
	Iterator<Deadline> getListOfDeadlinesCourse();

	/**
	 * Returns the list of tests of a course
	 * @return Array of CourseTests
	 */
	Iterator<CourseTests> getListOfTestsCourse();
}
