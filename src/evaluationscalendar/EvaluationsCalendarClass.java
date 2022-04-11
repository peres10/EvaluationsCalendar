package evaluationscalendar;

import dataStructures.*;

public class EvaluationsCalendarClass implements EvaluationsCalendar {
	Array<Person> people;
	Array<Courses> courses;
	public EvaluationsCalendarClass() {
		people = new ArrayClass<>();
		courses = new ArrayClass<>();
	}
	
	@Override
	public void addStudent(String name, int numStudent) {
		people.insertLast(new StudentClass(name, numStudent));
	}

	@Override
	public void addProfessor(String name) {
		people.insertLast(new ProfessorClass(name));
	}

	@Override
	public boolean existPerson(String name) {
		Iterator<Person> it = listAllPeople();
		while(it.hasNext()) {
			if(it.next().getName().equals(name))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean existStudentNum(int numStudent) {
		Iterator<Person> it = listAllPeople();
		Person person;
		while(it.hasNext()) {
			person=it.next();
			if(person instanceof StudentClass) {
				if (((StudentClass)person).getStudentNumber() == numStudent)
					return true;
			}
		}
		return false;
	}	
	
	@Override
	public Iterator<Person> listAllPeople() {
		return people.iterator();
	}
	
	public Iterator<Courses> listAllCourses() {
		return courses.iterator();
	}

	@Override
	public boolean existCourses() {
		Iterator<Courses> it = listAllCourses();
		if(it.hasNext())
			return true;
		return false;
	}
}
