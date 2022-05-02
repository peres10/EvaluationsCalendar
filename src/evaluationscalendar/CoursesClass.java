package evaluationscalendar;

import dataStructures.*;
import java.time.*;

/**
 * A course with Students and Professors assigned to it, also has a list of deadlines and tests
 */
public class CoursesClass implements Courses {
	private final String courseName;

	private Array<Person> professors;
	private Array<Person> students;
	private Array<Deadline> deadlines;
	private Array<CourseTests> tests;
	
	public CoursesClass(String courseName) {
		this.courseName = courseName;
		professors = new ArrayClass<>();
		students = new ArrayClass<>();
		tests = new ArrayClass<>();
		deadlines = new ArrayClass<>();
	}

	/******************************************* Setters *******************************************/

	/*
		Adds a professor to the course
	 */
	@Override
	public void addProfessor(Person professor) {
		professors.insertLast(professor);
	}

	/*
		Adds a student to the course
	 */
	@Override
	public void addStudent(Person student) {
		students.insertLast(student);
	}

	/*
		Adds a test to a course
	 */
	@Override
	public void addTest(LocalDateTime testDate,int duration,String testName,String courseName) {
		this.tests.insertLast(new CourseTestsClass(testDate,duration,testName,courseName));
		this.tests = this.tests.sort();
	}

	/*
		Adds a deadline to a course
	 */
	@Override
	public void addDeadline(LocalDate deadlineDate,String name) {
		this.deadlines.insertLast(new DeadlineClass(deadlineDate,name,this.courseName));
		this.deadlines = this.deadlines.sort();
	}


	/*
	****************************************** Getters ******************************************
	*/

	/*
		Gets the name of a course
	 */
	@Override
	public String getName() {
		return this.courseName;
	}

	/*
		Gets the number of professors of a course
	 */
	@Override
	public int getNumberOfProfessors() {
		return professors.size();
	}

	/*
		Gets the number of students of a course
	 */
	@Override
	public int getNumberOfStudents() {
		return students.size();
	}

	/*
		Gets the number of tests of a course
	 */
	@Override
	public int getNumberOfTests() {
		return tests.size();
	}

	/*
		Gets the number of deadlines of a course
	 */
	@Override
	public int getNumberOfDeadlines() {
		return deadlines.size();
	}


	/*
	****************************************** Pre-Conditions ******************************************
	 */

	/*
		Checks if a deadline with a specific name already exists in the course
	 */
	public boolean hasDeadline(String deadlineName){
		return searchDeadline(deadlineName) != null;
	}

	/*
	*************************************** Itearators & Array's ****************************************
	*/

	/*
		Returns the list of professors of a course
	 */
	@Override
	public Iterator<Person> getListOfProfessorsCourse() {
		return professors.iterator();
	}

	/*
		Returns the list of students of a course
	 */
	@Override
	public Iterator<Person> getListOfStudentsCourse() {
		return students.iterator();
	}

	/*
		Returns the array of students in a course
	 */
	@Override
	public Array<Person> getArrayOfStudents() { 
		return students; 
	}

	/*
		Returns the array of professors in a course
	 */
	@Override
	public Array<Person> getArrayOfProfessors() { 
		return professors; 
	}

	/*
		Returns the list of deadlines of a course
	 */
	@Override
	public Iterator<Deadline> getListOfDeadlinesCourse() { return deadlines.iterator(); }

	/*
		Returns the list of tests of a course
	 */
	@Override
	public Iterator<CourseTests> getListOfTestsCourse() {
		return tests.iterator();
	}


	/*
	 *************************************** Private Methods *************************************
	 */

	/*
		Searches a deadline with a specific name in the Array of Deadlines
	 */
	private Deadline searchDeadline(String deadlineName) {
		Iterator<Deadline> deadlineIt = getListOfDeadlinesCourse();
		Deadline deadline;
		while(deadlineIt.hasNext()) {
			deadline = deadlineIt.next();
			if(deadline.getName().equals(deadlineName))
				return deadline;
		}
		return null;
	}
}
