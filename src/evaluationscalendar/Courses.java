package evaluationscalendar;

import dataStructures.Iterator;

public interface Courses {
	String getName();
	void addProfessor(Person professor);
	
	void addStudent(Person student);
	
	void addTest();
	
	void addDeadline();
	
	int getNumberOfProfessors();
	
	int getNumberOfStudents();
	
	int getNumberOfTests();
	
	int getNumberOfDeadlines();

	Iterator<Person> getListOfProfessorsCourse();

	Iterator<Person> getListOfStudentsCourse();
}
