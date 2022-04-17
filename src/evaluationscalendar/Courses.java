package evaluationscalendar;

import dataStructures.Array;
import dataStructures.Iterator;

/**
 * A course with Students and Professors assigned to it and the deadlines
 */
public interface Courses {
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

	//not commented yet
	void addTest();

	//not commented yet
	void addDeadline();

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
	 * Gets the number of student of a course
	 * @return int with the number of professors of the course
	 */
	int getNumberOfStudents();

	//not commented yet
	int getNumberOfTests();

	//not commented yet
	int getNumberOfDeadlines();

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

	Array<Person> getArrayOfProfessors();

	Array<Person> getArrayOfStudents();
}
