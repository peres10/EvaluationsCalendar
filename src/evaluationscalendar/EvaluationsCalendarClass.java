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

	private Courses searchCourse(String courseName) {
		Iterator<Courses> courseIt = listAllCourses();
		Courses course;
		while(courseIt.hasNext()) {
			course = courseIt.next();
			if(course.getName().equalsIgnoreCase(courseName))
				return course;
		}
		return null;
	}

	private Person searchPerson(String personName) {
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
		//Courses course = searchCourse(courseName);
		//Person professor = searchPerson(professorName);
		//course.addProfessor(professor);
		//course.addProfessor(searchPerson(professorName));
		searchCourse(courseName).addProfessor(searchPerson(professorName));
	}

	@Override
	public void enrolStudentInCourse(String studentName, String courseName) {
		Courses course = searchCourse(courseName);
		//Person student = searchPerson(studentName);
		//course.addStudent(student);	
		searchCourse(courseName).addStudent(searchPerson(studentName));
	}

	@Override
	public Iterator<Person> courseIntersectionStudents(Array<String> coursesName) {
		Array<Courses> courses=null;
		Array<Person> result;
		for(int i=0;i<coursesName.size();i++){
			courses.insertLast(searchCourse(coursesName.get(i)));
		}
		result=courses.get(0).getArrayOfStudents();
		for(int j=1;j<coursesName.size();j++){
			result=intersectTwoArrays(result,courses.get(j).getArrayOfStudents()));
		}
		return result.iterator();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Person> courseIntersectionProfessors(Array<String> coursesName) {
		Array<Courses> courses=null;
		Array<Person> result;
		for(int i=0;i<coursesName.size();i++){
			courses.insertLast(searchCourse(coursesName.get(i)));
		}
		result=courses.get(0).getArrayOfProfessors();
		for(int j=1;j<coursesName.size();j++){
			result=intersectTwoArrays(result,courses.get(j).getArrayOfProfessors());
		}
		return result.iterator();
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

	private Array<Person> intersectTwoArrays(Array<Person> firstArray, Array<Person> secondArray) {
		Array<Person> result = null;
		for(int i=0;i<firstArray.size();i++){
			for(int j=0;j<secondArray.size();j++) {
				if (firstArray.get(i).equals(secondArray.get(j)))
					result.insertLast(firstArray.get(i));
				break;
			}
		}
		return result;
	}
}
