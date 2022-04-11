package evaluationscalendar;

import dataStructures.*;

public class EvaluationsCalendarClass implements EvaluationsCalendar {
	Array<Person> people;
	
	public EvaluationsCalendarClass() {
		people = new ArrayClass<>();
	}
	
	@Override
	public void addStudent(String name, int numStudent) {
		
		
	}

	@Override
	public void addProfessor(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existPerson(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean existStudentNum(int numStudent) {
		// TODO Auto-generated method stub
		return false;
	}	
	
	@Override
	public Iterator<People> listAllPeople() {
		// TODO Auto-generated method stub
		return null;
	}
}
