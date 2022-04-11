package evaluationscalendar;

import java.util.Iterator;

public interface EvaluationsCalendar {
	
	void addStudent(String name, int numStudent);

	void addProfessor(String name);
	
	boolean existPerson(String name);

	boolean existStudentNum(int numStudent);
	
	Iterator<Person> listAllPeople();

}
