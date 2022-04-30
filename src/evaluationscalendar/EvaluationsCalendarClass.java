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
			if(course.getName().equals(courseName))
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
		searchCourse(courseName).addProfessor(searchPerson(professorName));
		searchPerson(professorName).addCourse(searchCourse(courseName));
	}

	@Override
	public void enrolStudentInCourse(String studentName, String courseName) {
		searchCourse(courseName).addStudent(searchPerson(studentName));
		searchPerson(studentName).addCourse(searchCourse(courseName));
	}

	@Override
	public Iterator<Person> courseIntersectionStudents(Array<String> coursesName) {
		Array<Courses> courses= new ArrayClass<>();
		Array<Person> students = new ArrayClass<>();
		
		for(int i=0;i<coursesName.size();i++){
			courses.insertLast(searchCourse(coursesName.get(i)));
		}
		students = courses.get(0).getArrayOfStudents();
		for(int j = 1; j < coursesName.size(); j++){
			students = intersectTwoArrays(students, courses.get(j).getArrayOfStudents());
		}
		return students.iterator();
	}

	@Override
	public Iterator<Person> courseIntersectionProfessors(Array<String> coursesName) {
		Array<Courses> courses = new ArrayClass<>();
		Array<Person> professors = new ArrayClass<>();
		
		for(int i=0;i<coursesName.size();i++){
			courses.insertLast(searchCourse(coursesName.get(i)));
		}
		professors=courses.get(0).getArrayOfProfessors();
		for(int j=1;j<coursesName.size();j++){
			professors=intersectTwoArrays(professors,courses.get(j).getArrayOfProfessors());
		}
		return professors.iterator();
	}

	private Array<Person> intersectTwoArrays(Array<Person> firstArray, Array<Person> secondArray) {
		Array<Person> result = new ArrayClass<>();
	
		for(int i = 0; i < firstArray.size(); i++) {
			for(int j = 0; j < secondArray.size(); j++) {
				if (firstArray.get(i).equals(secondArray.get(j))){
					result.insertLast(firstArray.get(i));
					break;
				}
			}
		}
		return result;
	}

	@Override
	public boolean hasDeadlinesCourse(String courseName) {
		if(searchCourse(courseName).getNumberOfDeadlines() > 0)
			return true;
		return false;
	}

	@Override
	public boolean hasTestsCourse(String courseName) {
		if(searchCourse(courseName).getNumberOfTests() > 0)
			return true;
		return false;
	}

	@Override
	public Array<Deadline> getCourseDeadlines(String courseName) {
		searchCourse(courseName);//getdeadlines
		return null;
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

	public boolean hasDeadlineInCourse(String courseName, String deadlineName){
		Courses course=searchCourse(courseName);
		return course.hasDeadline(deadlineName);
	}

	private void getCoursesStudent(Person student) {
		Iterator<Courses> coursesIT = listAllCourses();
		Courses course;
		Array<Deadline> deadlines = new ArrayClass<>();
		while(coursesIT.hasNext()) {
			course = coursesIT.next();
			if(studentInCourse(student.getName(),course.getName()))
				return;//deadlines.insertLast(getCourseDeadlines(course.getName()));
		}

	}

	public Iterator<Deadline> listAllDeadlinesInACourse(String courseName) {
		return searchCourse(courseName).getListOfDeadlinesCourse();
	}

	@Override
	public Iterator<CourseTests> listAllTestsInACourse(String courseName) {
		return searchCourse(courseName).getListOfTestsCourse();
	}

	public void addDeadlineCourse(String courseName, String deadlineName,int year, int month, int day){
		Courses course = searchCourse(courseName);
		course.addDeadline(year,month,day,deadlineName);
	}

	@Override
	public Iterator<Deadline> getPersonalDeadlines(String personName) {
		Iterator<Courses> coursesIT = searchPerson(personName).getListOfCoursesInPerson();
		Iterator<Deadline> deadlinesIT = null;
		Courses course;
		Array<Deadline> deadlines = new  ArrayClass<>();
		Array<Deadline> deadlinesAux;
		
		while(coursesIT.hasNext()) {
            course = coursesIT.next();
            addDeadlineToDeadlineArray(deadlinesIT,course.getName(),deadlines);
		}
		
		deadlinesAux = deadlines.sort();
		deadlinesAux = sortAlphabetically(deadlinesAux);
		return deadlinesAux.iterator();
	}

	private void addDeadlineToDeadlineArray(Iterator <Deadline> deadlinesIT,String courseName,Array<Deadline> deadlines){
		deadlinesIT = listAllDeadlinesInACourse(courseName);
		while(deadlinesIT.hasNext())
			deadlines.insertLast(deadlinesIT.next());
	}

	@Override
	public Iterator<CourseTests> getPersonalTests(String personName) {
		Iterator<Courses> coursesIT = searchPerson(personName).getListOfCoursesInPerson();
		Iterator<CourseTests> testsIT = null;
		Courses course;
		Array<CourseTests> tests = new  ArrayClass<>();
		Array<CourseTests> testsAux;
		
		while(coursesIT.hasNext()) {
            course = coursesIT.next();
            addTestToTestArray(testsIT,course.getName(),tests);
		}
		testsAux = tests.sort();
		return testsAux.iterator();

	}

	private Array<Deadline> sortAlphabetically(Array<Deadline> deadlines) {
		Deadline dd1, dd2, deadlineAux;
		for(int i = 0; i < deadlines.size() - 1; i++) {
			dd1 = deadlines.get(i);
			dd2 = deadlines.get(i+1);
			if(dd1.compareTo(dd2) == 0 && dd1.getDeadlineCourse().compareTo(dd2.getDeadlineCourse()) > 0) {
				deadlineAux = deadlines.get(i);
				deadlines.removeAt(i);
				deadlines.insertAt(deadlineAux, i + 1);
			}
		}
		
		return deadlines;
	}

	private void addTestToTestArray(Iterator<CourseTests> testsIT, String courseName, Array<CourseTests> tests) {
		testsIT = listAllTestsInACourse(courseName);
		while(testsIT.hasNext())
			tests.insertLast(testsIT.next());		
	}

	@Override
	public Person superProfessor() {
		Iterator<Person> personIT = listAllPeople();
		Person person, superProfessor = null;
		int mostStudents = -1;
		
		while(personIT.hasNext()) {
			person = personIT.next();
			if(person instanceof ProfessorClass && mostStudents < ((ProfessorClass) person).getNumberOfStudents()) {
				mostStudents = ((ProfessorClass) person).getNumberOfStudents();
				superProfessor = person;
			}
		}
		
		return ((ProfessorClass)superProfessor);
	}

}