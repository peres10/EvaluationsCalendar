package evaluationscalendar;

import dataStructures.*;
import java.time.*;

/**
 * An Evaluation Calendar system that has Persons(Students or Professors), Courses and Deadlines
 * is used to manage the Persons of a course and the deadlines of courses
 */
public class EvaluationsCalendarClass implements EvaluationsCalendar {
	private Array<Person> people;
	private Array<Courses> courses;

	public EvaluationsCalendarClass() {
		people = new ArrayClass<>();
		courses = new ArrayClass<>();
	}


	/*
	 ****************************************** Setters ******************************************
	 */

	/*
		Adds a student to the system
	 */
	@Override
	public void addStudent(String studentName, int numStudent) {
		people.insertLast(new StudentClass(studentName, numStudent));
	}

	/*
		Adds a professor to the system
	 */
	@Override
	public void addProfessor(String professorName) {
		people.insertLast(new ProfessorClass(professorName));
	}

	/*
		Adds a course to the system
	 */
	@Override
	public void addCourse(String courseName) {
		courses.insertLast(new CoursesClass(courseName));
	}

	/*
		Assigns a professor to a given course
	 */
	@Override
	public void assignProfessorToCourse(String professorName, String courseName) {
		searchCourse(courseName).addProfessor(searchPerson(professorName));
		searchPerson(professorName).addCourse(searchCourse(courseName));
	}

	/*
		Enrolls a student to a given course
	 */
	@Override
	public void enrolStudentInCourse(String studentName, String courseName) {
		searchCourse(courseName).addStudent(searchPerson(studentName));
		searchPerson(studentName).addCourse(searchCourse(courseName));
	}

	/*
		Adds a deadline to a course
	 */
	public void addDeadlineCourse(String courseName,String deadlineName,LocalDate deadlineDate){
		Courses course = searchCourse(courseName);
		course.addDeadline(deadlineDate,deadlineName);
	}


	/*
	 ****************************************** Getters ******************************************
	 */

	/*
		Devolve o professor que tem mais alunos
	 */
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


	/*
	 ****************************************** Pre-Conditions ******************************************
	 */

	/*
		Checks if a person with the given name is registered
	 */
	@Override
	public boolean existPerson(String personName) {
		return searchPerson(personName) != null;
	}

	/*
		Checks if there is any student with the given student number
	 */
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

	/*
		Check if a course with the given name already exists
	 */
	@Override
	public boolean existsCourse(String courseName) {
		return searchCourse(courseName) != null;
	}

	/*
		Checks if a student is in a given course
	 */
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

	/*
		Checks if a professor is in a given course
	 */
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

	/*
		Check if there is at least one deadline in a course
	 */
	@Override
	public boolean hasDeadlinesCourse(String courseName) {
		if(searchCourse(courseName).getNumberOfDeadlines() > 0)
			return true;
		return false;
	}

	/*
		Check if there is at least one test in a course
	 */
	@Override
	public boolean hasTestsCourse(String courseName) {
		if(searchCourse(courseName).getNumberOfTests() > 0)
			return true;
		return false;
	}

	/*
		Check if a deadline with a specific name exists in a course, also given its name
	 */
	public boolean hasDeadlineInCourse(String courseName, String deadlineName){
		Courses course=searchCourse(courseName);
		return course.hasDeadline(deadlineName);
	}


	/*
	 ****************************************** Iterators & Array's ******************************************
	 */

	/*
		Gets the list of students in the intersection of multiple courses
	 */
	@Override
	public Iterator<Person> courseIntersectionStudents(Array<String> coursesName) {
		Array<Courses> courses= new ArrayClass<>();
		Array<Person> students = new ArrayClass<>();

		for(int i=0;i<coursesName.size();i++){
			courses.insertLast(searchCourse(coursesName.get(i)));
		}
		students = courses.get(0).getArrayOfStudents();
		for(int j = 1; j < coursesName.size(); j++){
			students = intersectTwoArraysOfPerson(students, courses.get(j).getArrayOfStudents());
		}
		return students.iterator();
	}

	/*
		Gets the list of professors in the intersection of multiple courses
	 */
	@Override
	public Iterator<Person> courseIntersectionProfessors(Array<String> coursesName) {
		Array<Courses> courses = new ArrayClass<>();
		Array<Person> professors = new ArrayClass<>();

		for(int i=0;i<coursesName.size();i++){
			courses.insertLast(searchCourse(coursesName.get(i)));
		}
		professors=courses.get(0).getArrayOfProfessors();
		for(int j=1;j<coursesName.size();j++){
			professors=intersectTwoArraysOfPerson(professors,courses.get(j).getArrayOfProfessors());
		}
		return professors.iterator();
	}

	/*
		Returns all the people registered in the system
	 */
	@Override
	public Iterator<Person> listAllPeople() {
		return people.iterator();
	}

	/*
		Returns all the courses in the system
	 */
	@Override
	public Iterator<Courses> listAllCourses() {
		return courses.iterator();
	}

	/*
		Returns all the students in a given course
	 */
	@Override
	public Iterator<Person> listStudentsInCourse(String courseName) {
		return searchCourse(courseName).getListOfStudentsCourse();
	}

	/*
		Returns all the professors in a given course
	 */
	@Override
	public Iterator<Person> listProfessorsInCourse(String courseName) {
		return searchCourse(courseName).getListOfProfessorsCourse();
	}

	/*
		Returns all the deadlines of a course
	 */
	@Override
	public Iterator<Deadline> listAllDeadlinesInACourse(String courseName) {
		return searchCourse(courseName).getListOfDeadlinesCourse();
	}
	/*
		Returns all the tests of a course
	 */
	@Override
	public Iterator<CourseTests> listAllTestsInACourse(String courseName) {
		return searchCourse(courseName).getListOfTestsCourse();
	}

	/*
		 Returns all the deadlines of a specific Student
	 */
	@Override
	public Iterator<Deadline> getPersonalDeadlines(String personName) {
		Iterator<Courses> coursesIT = searchPerson(personName).getListOfCoursesInPerson();
		Iterator<Deadline> deadlinesIT = null;
		Courses course;
		Array<Deadline> deadlines = new  ArrayClass<>();

		while(coursesIT.hasNext()) {
			course = coursesIT.next();
			deadlinesIT=listAllDeadlinesInACourse(course.getName());
			while(deadlinesIT.hasNext())
				deadlines.insertLast(deadlinesIT.next());
		}

		deadlines = deadlines.sort();
		sortAlphabeticallyDeadlines(deadlines);
		return deadlines.iterator();
	}

	/*
		Returns all the tests of a specific Student
	 */
	@Override
	public Iterator<CourseTests> getPersonalTests(String personName) {
		Iterator<Courses> coursesIT = searchPerson(personName).getListOfCoursesInPerson();
		Iterator<CourseTests> testsIT = null;
		Courses course;
		Array<CourseTests> tests = new  ArrayClass<>();

		while(coursesIT.hasNext()) {
			course = coursesIT.next();
			testsIT=listAllTestsInACourse(course.getName());
			while(testsIT.hasNext())
				tests.insertLast(testsIT.next());
		}
		tests = tests.sort();
		return tests.iterator();

	}

	@Override
	public Iterator<Person> listStudentsStress() {
		Iterator<Person> personIT = listAllPeople();
		Person person;
		Array<Person> students = new ArrayClass<>();
		Array<Person> sortedStressedStudents;
		
		while(personIT.hasNext()) {
			person = personIT.next();
			if(person instanceof Student) {
				((Student) person).studentStressometer();
				students.insertLast(person);
			}
		}
		sortedStressedStudents = sortStressedStudents(students);
		return sortedStressedStudents.iterator();
	}

	/*
	 ****************************************** Funções privadas ******************************************
	 */

	/*
		Searches a course, by its name , in the Array of courses
	 */
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

	/*
		Searches a person, by its name , in the Array of persons
	 */
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

	/*
		Method to instersect two Arrays of Person
	 */
	private Array<Person> intersectTwoArraysOfPerson(Array<Person> firstArray, Array<Person> secondArray) {
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

	/*
		Sorts and Array of Deadlines Alphabetically
	 */
	private Array<Deadline> sortAlphabeticallyDeadlines(Array<Deadline> deadlines) {
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







	/*private void getCoursesStudent(Person student) {
		Iterator<Courses> coursesIT = listAllCourses();
		Courses course;
		Array<Deadline> deadlines = new ArrayClass<>();
		while(coursesIT.hasNext()) {
			course = coursesIT.next();
			if(studentInCourse(student.getName(),course.getName()))
				return;//deadlines.insertLast(getCourseDeadlines(course.getName()));
		}

	}*/

	public boolean hasTestInSameHourCourse(String courseName,LocalDateTime testDate,int duration){
		Iterator<CourseTests> testsIT = searchCourse(courseName).getListOfTestsCourse();
		while(testsIT.hasNext()){
			CourseTests testB=testsIT.next();
			LocalDateTime testBDate=testB.getDateHours();
			if(testDate.isBefore(testB.getTestEnding()) && testBDate.isBefore(testDate.plusHours(duration)))
				return true;
		}
		return false;
	}

	public int[] checkConflictsOfTest(String courseName,LocalDateTime testDate,int duration){
		int[] resultValues;
		Courses course = searchCourse(courseName);
		Array<Courses> allCoursesIntersected=getAllCoursesWithIntersection(course);
		Array<Courses> allCoursesWithTestInSameDay=getAllCoursesWithTestsInTheSameDay(allCoursesIntersected,testDate);
		if(allCoursesIntersected.size()==0 || allCoursesWithTestInSameDay.size()==0){
			resultValues = new int[]{0, 0, 0};
			return resultValues;
		}

		resultValues=checkIfSevere(courseName,allCoursesWithTestInSameDay,testDate,duration);
		return resultValues;
	}

	private Array<Courses> getAllCoursesWithIntersection(Courses course){
		Array<Courses> allCoursesIntersection = new ArrayClass<>();
		Iterator<Courses> coursesIT = listAllCourses();
		while(coursesIT.hasNext()){
			Courses courseB=coursesIT.next();
			Array<Person> personArray = intersectTwoArraysOfPerson(course.getArrayOfStudents(),courseB.getArrayOfStudents());
			if(!course.equals(courseB)) {
				if (personArray.size() > 0)
					allCoursesIntersection.insertLast(courseB);
				else {
					personArray = intersectTwoArraysOfPerson(course.getArrayOfProfessors(), courseB.getArrayOfProfessors());
					if (personArray.size() > 0)
						allCoursesIntersection.insertLast(courseB);
				}
			}
		}

		return allCoursesIntersection;
	}

	private Array<Courses> getAllCoursesWithTestsInTheSameDay(Array<Courses> intersectedCourses,LocalDateTime testDate){
		Iterator<Courses> intersectedCoursesIT = intersectedCourses.iterator();
		Array<Courses> coursesWithTestsInTheSameDay = new ArrayClass<>();

		while(intersectedCoursesIT.hasNext()){
			Courses course=intersectedCoursesIT.next();
			Iterator<CourseTests> testsIT = course.getListOfTestsCourse();
			while(testsIT.hasNext()){
				CourseTests testB = testsIT.next();
				LocalDateTime testBDate = testB.getDateHours();
				if(testBDate.getDayOfYear()==testDate.getDayOfYear() & testBDate.getYear()==testDate.getYear()) {
					coursesWithTestsInTheSameDay.insertLast(course);
					break;
				}
			}
		}
		return coursesWithTestsInTheSameDay;
	}

	private int[] checkIfSevere(String courseName,Array<Courses> courses,LocalDateTime testDate,int duration){
		Iterator<Courses> coursesIT = courses.iterator();
		int flag=0;
		Courses courseResult=null;
		CourseTests resultTest;

		while(coursesIT.hasNext()){
			Courses courseB=coursesIT.next();
			Iterator<CourseTests> testsIT = courseB.getListOfTestsCourse();
			while(testsIT.hasNext()){
				CourseTests testB = testsIT.next();
				LocalDateTime testBDate = testB.getDateHours();
				LocalDateTime testBDateEnd = testB.getTestEnding();
				if(flag==0 & testBDate.getDayOfYear()==testDate.getDayOfYear() & testBDate.getYear()==testDate.getYear()) {
					resultTest=testB;
					courseResult=courseB;
					flag=1;
				}
				if(testDate.isBefore(testBDateEnd) && testBDate.isBefore(testDate.plusHours(duration))) {
					resultTest = testB;
					courseResult=courseB;
					flag=2;
					break;
				}
			}
		}
		int numOfIntersectedStudents = intersectTwoArraysOfPerson(searchCourse(courseName).getArrayOfStudents(),courseResult.getArrayOfStudents()).size();
		int numOfIntersectedProfessors = intersectTwoArraysOfPerson(searchCourse(courseName).getArrayOfProfessors(),courseResult.getArrayOfProfessors()).size();

		int[] result = new int[]{flag,numOfIntersectedProfessors,numOfIntersectedStudents};
		return result;
	}

	public void addTestCourse(String courseName,String testName,LocalDateTime testDate,int duration){
		Courses course = searchCourse(courseName);
		course.addTest(testDate,duration,testName,courseName);
	}

	public boolean hasTestInCourse(String courseName,String testName){
		Iterator<CourseTests> testsIT = searchCourse(courseName).getListOfTestsCourse();
		while(testsIT.hasNext()){
			if(testsIT.next().getName().equals(testName))
				return true;
		}
		return false;
	}
	
	private Array<Person> sortStressedStudents(Array<Person> students) {
        Person student;
        for(int i = 0; i <students.size(); i++) {
            for(int j = 0; i < students.size(); j++) {
                if(((Student)students.get(i)).getConsecutiveDaysWithTests() < ((Student)students.get(j)).getConsecutiveDaysWithTests()) {
                    student = students.get(i);
                    students.removeAt(i);
                    students.insertAt(students.get(j), i);
                    students.removeAt(j);
                    students.insertAt(student, j);
                }
            }
        }
        return students;
    }
}