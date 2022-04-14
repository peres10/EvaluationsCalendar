package evaluationscalendar;

import dataStructures.*;

public class EvaluationsCalendarClass implements EvaluationsCalendar {
	private Array<Person> people;
	private Array<Courses> courses;
	public EvaluationsCalendarClass() {
		people = new ArrayClass<>();
		courses = new ArrayClass<>();
	}
	
	@Override
	public void addStudent(String studentName, int numStudent) {
		people.insertLast(new StudentClass(studentName, numStudent));
	}

	@Override
	public void addProfessor(String professorName) {
		people.insertLast(new ProfessorClass(professorName));
	}

	@Override
	public void addCourse(String courseName) {
		courses.insertLast(new CoursesClass(courseName));
	}

	@Override
	public boolean existPerson(String personName) {
		return searchPerson(personName) != null;
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
	public boolean existsCourse(String courseName) {
		return searchCourse(courseName) != null;
	}

	public Courses searchCourse(String courseName) {
		Iterator<Courses> courseIt = listAllCourses();
		Courses course;
		while(courseIt.hasNext()) {
			course = courseIt.next();
			if(course.getName().equalsIgnoreCase(courseName))
				return course;
		}
		return null;
	}

	public Person searchPerson(String personName) {
		Iterator<Person> personIt = listAllPeople();
		Person person;
		while(personIt.hasNext()) {
			person = personIt.next();
			if(person.getName().equalsIgnoreCase(personName))
				return person;
		}
		return null;		
	}

	@Override
	public boolean studentInCourse(String studentName, String courseName) {
		Iterator<Person> studentIt = listStudentsInCourse(courseName);
		Person student;
		
		while(studentIt.hasNext()) {
			student = studentIt.next();
			if(student.getName().equals(studentName))
					return true;		
		}	
		return false;
	}

	@Override
	public boolean professorInCourse(String professorName, String courseName) {
		Iterator<Person> professorIt = listProfessorsInCourse(courseName);
		Person professor;
		
		while(professorIt.hasNext()) {
			professor = professorIt.next();
			if(professor.getName().equals(professorName))
					return true;		
		}	
		return false;
	}

	@Override
	public void assignProfessorToCourse(String professorName, String courseName) {
		
	}

	@Override
	public void enrolStudentInCourse(String studentName, String courseName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Person> listAllPeople() {
		return people.iterator();
	}

	@Override
	public Iterator<Courses> listAllCourses() {
		return courses.iterator();
	}

	@Override
	public Iterator<Person> listStudentsInCourse(String courseName) {
		return searchCourse(courseName).getListOfStudentsCourse();
	}

	@Override
	public Iterator<Person> listProfessorsInCourse(String courseName) {
		return searchCourse(courseName).getListOfProfessorsCourse();
	}
}
