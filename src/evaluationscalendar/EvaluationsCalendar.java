package evaluationscalendar;

import dataStructures.*;

public interface EvaluationsCalendar {
	
	void addStudent(String name, int numStudent);

	void addProfessor(String name);
	
	void addCourse(String courseName);

	boolean existPerson(String name);

	boolean existStudentNum(int numStudent);
	
	boolean existsCourse(String courseName);

	Courses searchCourse(String courseName);

	Person searchPerson(String personName);
	
	boolean studentInCourse(String studentName, String courseName);

	boolean professorInCourse(String professorName, String courseName);

	void assignProfessorToCourse(String professorName, String courseName);

	void enrolStudentInCourse(String studentName, String courseName);

	Array<Person> courseIntersectionStudents(Array<String> coursesName);

	Array<Person> courseIntersectionProfessors(Array<String> coursesName);
	
	Iterator<Person> listAllPeople();

	Iterator<Courses> listAllCourses();

	Iterator<Person> listStudentsInCourse(String courseName);

	Iterator<Person> listProfessorsInCourse(String courseName);

}
