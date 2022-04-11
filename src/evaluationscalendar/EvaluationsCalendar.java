package evaluationscalendar;

import dataStructures.*;

public interface EvaluationsCalendar {
	
	void addStudent(String name, int numStudent);

	void addProfessor(String name);
	
	boolean existPerson(String name);

	boolean existStudentNum(int numStudent);
	
	Iterator<Person> listAllPeople();

	Iterator<Courses> listAllCourses();

	boolean existsCourse(String courseName);

	void addCourse(String courseName);

}
