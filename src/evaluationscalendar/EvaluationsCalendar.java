package evaluationscalendar;

import dataStructures.*;
import java.time.*;

/**
 * An Evaluation Calendar system that has Persons(Students or Professors), Courses and Deadlines
 * is used to manage the Persons of a course and the deadlines of courses
 * @author Tomas Ferreira n�61733
 * @author Alexandre Peres n�61615
 */
public interface EvaluationsCalendar {

	/*
	 ****************************************** Setters ******************************************
	 */

	/**
	 * Adds a student to the system
	 * @pre !existPerson(name) && !existStudentNum(numStudent)
	 * @param name - name of the person
	 * @param numStudent - number of the student
	 */
	void addStudent(String name, int numStudent);

	/**
	 * Adds a professor to the system
	 * @pre !existPerson(name)
	 * @param name - name of the professor
	 */
	void addProfessor(String name);

	/**
	 * Adds a course to the system
	 * @pre !existsCourse(courseName)
	 * @param courseName - name of the course
	 */
	void addCourse(String courseName);

	/**
	 * Assigns a professor to a given course
	 * @pre existCourse(courseName) & !professorInCourse(professorName,courseName)
	 * @param professorName - name of the professor
	 * @param courseName - name of the course
	 */
	void assignProfessorToCourse(String professorName, String courseName);

	/**
	 * Enrolls a student to a given course
	 * @pre existCourse(courseName) & !studentInCourse(studentName,courseName)
	 * @param studentName - name of the student
	 * @param courseName - name of the course
	 */
	void enrolStudentInCourse(String studentName, String courseName);

	/**
	 * Adds a deadline to a course
	 * @pre existCourse(courseName) & !hasDeadlineInCourse(courseName,deadlineName)
	 * @param courseName
	 * @param deadlineName
	 * @param deadlineDate
	 */
	void addDeadlineCourse(String courseName,String deadlineName,LocalDate deadlineDate);

	/**
	 * Returns the conflicts of the test, the array returned is supposed to simulate a tuple, the first element
	 * 		is a number to represent the conflitct text (0 if free,1 if mild and 2 if severe) , the second element is the professors with conflict
	 * 		and the third element is the students with conflict
	 * @param courseName - the name of the course
	 * @param testDate - the date of the test
	 * @param duration - the duration of the test
	 * @return int[] with 3 elements, the first element is a variable to represent the conflict, the second element is the professors with conflit
	 * 			the third element is the students with conflict
	 */
	int[] checkConflictsOfTest(String courseName,LocalDateTime testDate,int duration);

	/**
	 * Adds a test to a course
	 * @param courseName - name of the course
	 * @param testName - name of the test
	 * @param testDate - date of the test
	 * @param duration - duration of the test
	 */
	void addTestCourse(String courseName,String testName,LocalDateTime testDate,int duration);

	/*
	 ****************************************** Getters ******************************************
	 */

	/**
	 * Devolve o professor que tem mais alunos
	 * @return Person - com um professor
	 */
	Person superProfessor();


	/*
	 ****************************************** Pre-Conditions ******************************************
	 */

	/**
	 * Checks if a person with the given name is registered
	 * @param name - name of the person
	 * @return boolean , true if exists , false if not
	 */
	boolean existPerson(String name);

	/**
	 * Checks if there is any student with the given student number
	 * @param numStudent - number of the student
	 * @return boolean, true if exists, false if not
	 */
	boolean existStudentNum(int numStudent);

	/**
	 * Check if a course with the given name already exists
	 * @param courseName - name of the course
	 * @return boolean , true if exists , false if not
	 */
	boolean existsCourse(String courseName);

	/**
	 * Checks if a student is in a given course
	 * @pre !existCourse(courseName)
	 * @param studentName - name of the student to search
	 * @param courseName - course name
	 * @return boolean , true if the student is in the course , false if not
	 */
	boolean studentInCourse(String studentName, String courseName);

	/**
	 * Checks if a professor is in a given course
	 * @pre !existCourse(courseName)
	 * @param professorName - name of the professor to search
	 * @param courseName - course name
	 * @return boolean , true if the professor is in the course, false if not
	 */
	boolean professorInCourse(String professorName, String courseName);

	/**
	 * Check if a deadline with a specific name exists in a course, also given its name
	 * @pre !existCourse(courseName)
	 * @param courseName - the name of the course
	 * @param deadlineName - the name of the deadline
	 * @return boolean, true if the deadline exists, false it not
	 */
	boolean hasDeadlineInCourse(String courseName, String deadlineName);

	/**
	 * Check if there is at least one test in a course
	 * @pre !existCourse(courseName)
	 * @param courseName - the name of the course
	 * @return boolean, true if it exists, false if not
	 */
	boolean hasTestsCourse(String courseName);

	/**
	 * Check if there is at least one deadline in a course
	 * @pre !existCourse(courseName)
	 * @param courseName - the name of the course
	 * @return boolean, true if it exists, false if not
	 */
	boolean hasDeadlinesCourse(String courseName);

	/**
	 * Check if two tests intersect
	 * @param courseName - the name of the course
	 * @param testDate - the date of the taste
	 * @param duration - the duration of the test
	 * @return boolean, true if there any test at the same time, false if not
	 */
	boolean hasTestInSameHourCourse(String courseName,LocalDateTime testDate,int duration);

	/**
	 * Check if a course has a test given its name
	 * @param courseName - name of the course
	 * @param testName - name of the test
	 * @return true if is exists, false if not
	 */
	boolean hasTestInCourse(String courseName,String testName);

	/**
	 * Check if there is a student given its name
	 * @param personName - name of the student to search
	 * @return true if exists, false if not
	 */
	boolean existStudent(String personName);

	/*
	 ****************************************** Iterators & Array's ******************************************
	 */

	/**
	 * Gets the list of students in the intersection of multiple courses
	 * @param coursesName - the name of the courses
	 * @return Iterator of Person (with Students)
	 */
	Iterator<Person> courseIntersectionStudents(Array<String> coursesName);

	/**
	 * Gets the list of professors in the intersection of multiple courses
	 * @param coursesName - the name of the courses
	 * @return Iterator of Person (with Professors)
	 */
	Iterator<Person> courseIntersectionProfessors(Array<String> coursesName);

	/**
	 * Returns all the people registered in the system
	 * @return Iterator of Person with everyone reigstered
	 */
	Iterator<Person> listAllPeople();

	/**
	 * Returns all the courses in the system
	 * @return Iterator of Courses with all courses in the system
	 */
	Iterator<Courses> listAllCourses();

	/**
	 * Returns all the students in a given course
	 * @param courseName - name of the course
	 * @return Iterator of Students with all students in a given course
	 */
	Iterator<Person> listStudentsInCourse(String courseName);

	/**
	 * Returns all the professors in a given course
	 * @param courseName - name of the course
	 * @return Iterator of Professor with all professors in a given course
	 */
	Iterator<Person> listProfessorsInCourse(String courseName);

	/**
	 * Returns all the deadlines of a course
	 * @param courseName - name of the course
	 * @return Iterator of Deadlines with all the deadlines in a given coure
	 */
	Iterator<Deadline> listAllDeadlinesInACourse(String courseName);

	/**
	 * Returns all the tests of a course
	 * @param courseName - name of the course
	 * @return Iterator of CourseTests with all the tests in a given course
	 */
	Iterator<CourseTests> listAllTestsInACourse(String courseName);

	/**
	 * Returns all the deadlines of a specific Student
	 * @param studentName - name of the student
	 * @return Iterator of Deadlines with all the deadlines of a Student
	 */
	Iterator<Deadline> getPersonalDeadlines(String studentName);

	/**
	 * Returns all the tests of a specific Student
	 * @param studentName - name of the student
	 * @return Iterator of Tests with all the deadlines of a Student
	 */
	Iterator<CourseTests> getPersonalTests(String personName);

	/**
	 * Returns and ordered list of students by its stress
	 * @return Iterator of Person with the Student
	 */
	Iterator<Person> listStudentsStress();


}
