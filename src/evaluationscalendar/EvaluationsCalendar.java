package evaluationscalendar;

import dataStructures.*;

/**
 * An Evaluation Calendar system that has Persons(Students or Professors), Courses and Deadlines
 * is used to manage the Persons of a course and the deadlines of courses
 */
public interface EvaluationsCalendar {

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
	 * @param studentName - name of the student to search
	 * @param courseName - course name
 	 * @return boolean , true if the student is in the course , false if not
	 */
	boolean studentInCourse(String studentName, String courseName);

	/**
	 * Checks if a professor is in a given course
	 * @param professorName - name of the professor to search
	 * @param courseName - course name
	 * @return boolean , true if the professor is in the course, false it not
	 */
	boolean professorInCourse(String professorName, String courseName);

	/**
	 * Assigned a professor to a given course
	 * @param professorName - name of the professor
	 * @param courseName - name of the course
	 */
	void assignProfessorToCourse(String professorName, String courseName);

	/**
	 * Enrolls a student to a given course
	 * @param studentName - name of the student
	 * @param courseName - name of the course
	 */
	void enrolStudentInCourse(String studentName, String courseName);

	// not commented yet
	Iterator<Person> courseIntersectionStudents(Array<String> coursesName);

	// not commented yet
	Iterator<Person> courseIntersectionProfessors(Array<String> coursesName);

	//not commented
	boolean hasDeadlinesCourse(String courseName);

	//not commented
	Array<Deadline> getCourseDeadlines(String courseName);

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

	Iterator<Deadline> listAllDeadlinesInACourse(String courseName);

	boolean hasDeadlineInCourse(String courseName, String deadlineName);

	void addDeadlineCourse(String courseName, String deadlineName,int year, int month, int day);

	Iterator<Deadline> getPersonalDeadlines(String studentName);

	boolean hasTestsCourse(String courseName);

	Iterator<CourseTests> listAllTestsInACourse(String courseName);

	Iterator<CourseTests> getPersonalTests(String personName);

	Person superProfessor();

	int getSuperProfessorStudents();
}
