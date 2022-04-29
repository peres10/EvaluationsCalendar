import evaluationscalendar.*;

import java.util.Scanner;

import dataStructures.*;

public class Main {


	/**
	 * Feedback dado pelo programa.
	 */
	//headers and listing formats
	private static final String HEADER_HELP_COMMAND = "Available commands:";
	private static final String HEADER_PROFESSORS = "Professors:";
	private static final String HEADER_STUDENTS = "Students:";
	private static final String HEADER_ALL_PEOPLE = "All people:";
	private static final String HEADER_ALL_COURSES = "All courses:";
	private static final String HEADER_ROSTER = "Roster for course %s:\n";
	private static final String HEADER_INTERSECTION = "Intersection:";
	private static final String HEADER_DEADLINES_COURSE = "Deadlines for course %s:\n";
	private static final String HEADER_DEADLINES_STUDENT = "Deadlines for %s:\n";
	private static final String HEADER_TESTS_COURSE = "Tests for couse %s:\n";
	private static final String HEADER_TESTS_STUDENT = "Tests for %s:\n";
	private static final String LIST_STUDENT_FORMAT = "[%d] %s (%d)\n";
	private static final String LIST_PROFESSOR_FORMAT = "%s (%d)\n";
	private static final String LIST_COURSES_FORMAT = "%s: %d professors, %d students, %d tests and %d deadlines.\n";
	private static final String LIST_STUDENT_W_NUMBER = "%d %s\n";
	private static final String LIST_DEADLINE_COURSE = "%s: %s\n";
    private static final String LIST_DEADLINE_STUDENT = "[%s] %s: %s\n";
    private static final String LIST_TEST_COURSE = "%s-%s: %s\n";
    private static final String LIST_TEST_STUDENT = "%s %s-%s: %s - %s\n";
    private static final String LIST_SUPERPROFESSOR = "%s (%d).\n";

    //error and success messages
	private static final String ERROR_UNKNOWN_COMMAND = "Unknown command %s. Type help to see available commands.\n";
	private static final String ERROR_EMPTY_DATABASE = "No people registered!";
	private static final String ERROR_ALREADY_EXIST_PERSON = "%s already exists!\n";
	private static final String ERROR_NUMBER_TAKEN = "There is already a student with the number %d!\n";
	private static final String ERROR_NO_COURSES = "No courses registered!";
	private static final String ERROR_COURSE_EXISTS = "Course %s already exists!\n";
	private static final String ERROR_COURSE_NOT_EXIST = "Course %s does not exist!\n";
	private static final String ERROR_PROFESSOR_NOT_EXIST = "Professor %s does not exist!\n";
	private static final String ERROR_STUDENT_NOT_EXIST = "Student %s does not exist!\n";
	private static final String ERROR_STUDENT_DEADLINE_NOT_EXIST = "%s does not exist!\n";
	private static final String ERROR_PROFESSOR_ALREADY_ASSIGNED = "Professor %s is already assigned to course %s!\n";
	private static final String ERROR_INADEQUATE_NUM_STUDENTS = "Inadequate number of students!";
	private static final String ERROR_INADEQUATE_NUM_COURSES = "Inadequate number of courses!";
	private static final String ERROR_STUDENT_ALREADY_ENROLLED = "Student %s is already enrolled in course %s!\n";
	private static final String ERROR_NO_ASSIGN_ENROL = "Course %s has no assigned professors and no enrolled students.\n";
	private static final String ERROR_NO_ONE_TO_LIST = "No professors or students to list!";
	private static final String ERROR_NO_DEADLINE_DEFINED = "No deadlines defined for %s!\n";
	private static final String ERROR_NO_TEST_SCHEDULED = "No scheduled tests for %s!\n";
	private static final String ERROR_DEADLINE_EXISTS = "Deadline %s already exists!\n";
	private static final String ERROR_TEST_EXISTS = "";
	private static final String ERROR_NO_PROFESSORS = "There are no professors!";
	
	private static final String PERSON_ADDED = "%s added.\n";
	private static final String COURSE_ADDED = "Course %s added.\n";
	private static final String PROFESSOR_ASSIGNED = "Professor %s assigned to %s.\n";
	private static final String STUDENTS_ADDED_TO_COURSE = "%d students added to course %s.\n";
	private static final String DEADLINE_ADDED_TO_COURSE = "Deadline %d-%02d-%02d added to %s.\n";


	private static final String EXIT_MSG = "Bye!";


	private enum Command{

		PEOPLE("lists all people"),
		PROFESSOR("adds a new professor"),
		STUDENT("adds a new student"),
		COURSES("lists all courses"),
		COURSE("adds a new course"),
		ROSTER("lists the professors and students of a course"),
		ASSIGN("adds a professor to a course"),
		ENROL("adds students to a course"),
		INTERSECTION("lists all the people involved in all the given courses"),
		COURSEDEADLINES("lists all deadlines in a given course"),
		PERSONALDEADLINES("lists all the deadlines of a given person"),
		DEADLINE("adds a new deadline"),
		COURSETESTS("lists all tests in a given course"),
		PERSONALTESTS("lists all tests for a given student"),
		SCHEDULE("add a new test to a course"),
		SUPERPROFESSOR("presents the professor with more students"),
		STRESSOMETER("presents the students with the top N stressful sequences of evaluations"),
		HELP("shows the available commands"),
		EXIT("terminates the execution of the program"),
		UNKNOWN("");

		private final String cmdDesc;

		Command(String cmdDesc) {
			this.cmdDesc=cmdDesc;
		}

		private String description() {
			return cmdDesc;
		}
	}

	public static void main(String[] args) {
		commands();
	}

	private static Command getCommand(String comm) {
		try {
			return Command.valueOf(comm);
		} catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}

	private static void commands(){
		EvaluationsCalendar evCalendar = new EvaluationsCalendarClass();
		Scanner in = new Scanner(System.in);
		String comm = in.next().toUpperCase();
		Command c = getCommand(comm);
		while(!c.equals(Command.EXIT)) {
			switch(c) {
			case HELP: helpCommands(); break;
			case PEOPLE: listAllPeople(evCalendar); break;
			case PROFESSOR: addProfessor(evCalendar, in); break;
			case STUDENT: addStudent(evCalendar, in); break;
			case COURSES: listAllCourses(evCalendar); break;
			case COURSE: addCourse(evCalendar, in); break;
			case ROSTER: courseRoster(evCalendar, in); break;
			case ASSIGN: assignProfessor(evCalendar, in); break;
			case ENROL: enrolStudent(evCalendar, in); break;
			case INTERSECTION: intersection(evCalendar, in); break;
			case COURSEDEADLINES: courseDeadlines(evCalendar, in); break;
			case PERSONALDEADLINES: personalDeadlines(evCalendar, in); break;
			case DEADLINE: addDeadline(evCalendar, in); break;
			case COURSETESTS: courseTests(evCalendar, in); break;
			case PERSONALTESTS: personalTests(evCalendar, in); break;
			case SCHEDULE: addTest(evCalendar, in); break;
			case SUPERPROFESSOR: superProfessor(evCalendar); break;
			case STRESSOMETER: stressometer(evCalendar, in); break;
			case UNKNOWN: System.out.printf(ERROR_UNKNOWN_COMMAND,comm); break;
			default: break;
			}
			comm = in.next().toUpperCase();
			c = getCommand(comm);
		}
		System.out.println(EXIT_MSG);
		in.close();
	}

	private static void helpCommands() {
		System.out.println(HEADER_HELP_COMMAND);
		for (Command command : Command.values()) {
			if(command==Command.UNKNOWN)
				return;
			System.out.println(command.name().toLowerCase() + " - " + command.description());
		}
	}

	private static void listAllPeople(EvaluationsCalendar evCalendar){
		Iterator<Person> it = evCalendar.listAllPeople();

		if(!it.hasNext()){
			System.out.println(ERROR_EMPTY_DATABASE);
		}
		else{
			System.out.println(HEADER_ALL_PEOPLE);
			while(it.hasNext()){
				Person person = it.next();
				if(person instanceof StudentClass){
					System.out.printf(LIST_STUDENT_FORMAT,((StudentClass) person).getStudentNumber(),person.getName(),person.getNumOfCourses());
				}
				else{
					System.out.printf(LIST_PROFESSOR_FORMAT,person.getName(),person.getNumOfCourses());
				}
			}
		}
	}

	private static void addProfessor(EvaluationsCalendar evCalendar,Scanner in){
		String name=in.nextLine().trim();
		if(evCalendar.existPerson(name)){
			System.out.printf(ERROR_ALREADY_EXIST_PERSON,name);
		}
		else{
			evCalendar.addProfessor(name);
			System.out.printf(PERSON_ADDED,name);
		}
	}

	private static void addStudent(EvaluationsCalendar evCalendar,Scanner in){
		int numStudent=in.nextInt();
		String name=in.nextLine().trim();
		if(evCalendar.existStudentNum(numStudent)){
			System.out.printf(ERROR_NUMBER_TAKEN,numStudent);
		}
		else if(evCalendar.existPerson(name)){
			System.out.printf(ERROR_ALREADY_EXIST_PERSON,name);
		}
		else{
			evCalendar.addStudent(name,numStudent);
			System.out.printf(PERSON_ADDED,name);
		}
	}

	private static void listAllCourses(EvaluationsCalendar evCalendar) {
		Courses course;
		Iterator<Courses> courseIt = evCalendar.listAllCourses();

		if(!courseIt.hasNext()) {
			System.out.println(ERROR_NO_COURSES);
		}
		else {
			System.out.println(HEADER_ALL_COURSES);
			while(courseIt.hasNext()) {
				course = courseIt.next();
				System.out.printf(LIST_COURSES_FORMAT, course.getName(), course.getNumberOfProfessors(), course.getNumberOfStudents(), course.getNumberOfTests(), course.getNumberOfDeadlines());
			}
		}
	}

	private static void addCourse(EvaluationsCalendar evCalendar, Scanner in) {
		String courseName = in.nextLine().trim();
		if(evCalendar.existsCourse(courseName))
			System.out.printf(ERROR_COURSE_EXISTS, courseName);
		else {
			evCalendar.addCourse(courseName);
			System.out.printf(COURSE_ADDED, courseName);
		}
	}

	private static void courseRoster(EvaluationsCalendar evCalendar, Scanner in){
		String courseName = in.nextLine().trim();
		Iterator<Person> studentsIT,professorsIT;
		Person person;
		if(!evCalendar.existsCourse(courseName)) {
			System.out.printf(ERROR_COURSE_NOT_EXIST, courseName);
			return;
		}
		
		professorsIT=evCalendar.listProfessorsInCourse(courseName);		
		studentsIT=evCalendar.listStudentsInCourse(courseName);

		if(!professorsIT.hasNext() && !studentsIT.hasNext())
			System.out.printf(ERROR_NO_ASSIGN_ENROL, courseName);
		else {
			professorsIT=evCalendar.listProfessorsInCourse(courseName);
			studentsIT=evCalendar.listStudentsInCourse(courseName);
			System.out.printf(HEADER_ROSTER, courseName);
			System.out.println(HEADER_PROFESSORS);
			while(professorsIT.hasNext()) {
				person = professorsIT.next();
				System.out.println(person.getName());
			}
			System.out.println(HEADER_STUDENTS);
			while(studentsIT.hasNext()){
				person = studentsIT.next();
				System.out.printf(LIST_STUDENT_W_NUMBER,((Student)person).getStudentNumber(),person.getName());
			}
		}
	}

	private static void assignProfessor(EvaluationsCalendar evCalendar, Scanner in) {
		String professorName = in.nextLine().trim();
		String courseName = in.nextLine().trim();
		if(!evCalendar.existPerson(professorName))
			System.out.printf(ERROR_PROFESSOR_NOT_EXIST, professorName);
		else if(!evCalendar.existsCourse(courseName))
			System.out.printf(ERROR_COURSE_NOT_EXIST, courseName);
		else if(evCalendar.professorInCourse(professorName, courseName))
			System.out.printf(ERROR_PROFESSOR_ALREADY_ASSIGNED, professorName, courseName);
		else {
			evCalendar.assignProfessorToCourse(professorName, courseName);
			System.out.printf(PROFESSOR_ASSIGNED, professorName, courseName);
		}
	}

	private static void enrolStudent(EvaluationsCalendar evCalendar, Scanner in) {
		int numStudents = in.nextInt();
		String courseName = in.nextLine().trim();
		int enrolledStudents = numStudents;
		if(numStudents <= 0) {
			System.out.println(ERROR_INADEQUATE_NUM_STUDENTS);
			return;
		}

		String currentStudent;
		Array<String> studentName = new ArrayClass<>();

		
		for(int i = 0; i < numStudents; i++) { 
			currentStudent = in.nextLine().trim();

			if(!evCalendar.existPerson(currentStudent)) {
				System.out.printf(ERROR_STUDENT_NOT_EXIST, currentStudent);
				enrolledStudents--;
			}
			else if(evCalendar.existsCourse(courseName) && evCalendar.studentInCourse(currentStudent, courseName)) {
				System.out.printf(ERROR_STUDENT_ALREADY_ENROLLED, currentStudent, courseName);
				enrolledStudents--;
			}
			else
				studentName.insertLast(currentStudent);
		}	

		if(!evCalendar.existsCourse(courseName)) {
			System.out.printf(ERROR_COURSE_NOT_EXIST, courseName);
			return;
		}
		
		for(int i = 0; i < enrolledStudents; i++)
			evCalendar.enrolStudentInCourse(studentName.get(i), courseName);

		System.out.printf(STUDENTS_ADDED_TO_COURSE, enrolledStudents, courseName);
	}

	private static void intersection(EvaluationsCalendar evCalendar, Scanner in) {
		int numCourses = in.nextInt();
		int i;
		Array<String> coursesName = new ArrayClass<>();
		Iterator<Person> studentsIT, professorsIT;
		Person professor;
		Student student;
		
		for(i = 0; i < numCourses; i++) 
			coursesName.insertLast(in.nextLine().trim());

		if(numCourses <= 1) {			
			System.out.println(ERROR_INADEQUATE_NUM_COURSES);
			return;
		}

		for(i = 0; i < numCourses; i++) { 			
			if(!evCalendar.existsCourse(coursesName.get(i))) {
				System.out.printf(ERROR_COURSE_NOT_EXIST, coursesName.get(i));
				return;
			}
		}

		professorsIT = evCalendar.courseIntersectionProfessors(coursesName);
		studentsIT = evCalendar.courseIntersectionStudents(coursesName);
		
		
		if(!professorsIT.hasNext() && !studentsIT.hasNext())
			System.out.println(ERROR_NO_ONE_TO_LIST);
		else {
			System.out.println(HEADER_INTERSECTION);
			System.out.println(HEADER_PROFESSORS);
			
			while(professorsIT.hasNext()) {
				professor = professorsIT.next();
				System.out.println(professor.getName());
			}
			
			System.out.println(HEADER_STUDENTS);
			while(studentsIT.hasNext()) {
				student = (Student) studentsIT.next();
				System.out.printf(LIST_STUDENT_W_NUMBER, student.getStudentNumber(), ((Person) student).getName());
			}		
		}
	}


	private static void courseDeadlines(EvaluationsCalendar evCalendar, Scanner in) {
		String courseName = in.nextLine().trim();
		Iterator<Deadline> deadlinesIt;

		if(!evCalendar.existsCourse(courseName))
			System.out.printf(ERROR_COURSE_NOT_EXIST, courseName);
		else {
			
			if(!evCalendar.hasDeadlinesCourse(courseName))
				System.out.printf(ERROR_NO_DEADLINE_DEFINED, courseName);
			else {
				deadlinesIt = evCalendar.listAllDeadlinesInACourse(courseName);
				System.out.printf(HEADER_DEADLINES_COURSE,courseName);
				while(deadlinesIt.hasNext()){
					Deadline deadline= deadlinesIt.next();
					System.out.printf(LIST_DEADLINE_COURSE,deadline.getName(),deadline.getDate().toString());
				}
			}
				
		}
	}

	private static void personalDeadlines(EvaluationsCalendar evCalendar, Scanner in) {
        String personName = in.nextLine().trim();
        Iterator<Deadline> deadlinesIT;
        Deadline deadline;

        if(!evCalendar.existPerson(personName))
            System.out.printf(ERROR_STUDENT_DEADLINE_NOT_EXIST, personName);
        else {
            deadlinesIT = evCalendar.getPersonalDeadlines(personName);
            
            if(!deadlinesIT.hasNext())
                System.out.printf(ERROR_NO_DEADLINE_DEFINED, personName);
            else {
                System.out.printf(HEADER_DEADLINES_STUDENT, personName);
                while(deadlinesIT.hasNext()) { 
                	deadline = deadlinesIT.next();
                	  System.out.printf(LIST_DEADLINE_STUDENT, deadline.getDeadlineCourse(), deadline.getName(), deadline.getDate());	
                }
                  
            }

        }
    }

	private static void addDeadline(EvaluationsCalendar evCalendar, Scanner in) {
		String courseName,deadlineName;
		int year,month,day;
		courseName = in.nextLine().trim();
		year=in.nextInt();
		month=in.nextInt();
		day=in.nextInt();
		deadlineName=in.nextLine().trim();
		if(!evCalendar.existsCourse(courseName))
			System.out.printf(ERROR_COURSE_NOT_EXIST,courseName);
		else{
			if(evCalendar.hasDeadlineInCourse(courseName,deadlineName))
				System.out.printf(ERROR_DEADLINE_EXISTS,deadlineName);
			else{
				evCalendar.addDeadlineCourse(courseName,deadlineName,year,month,day);
				System.out.printf(DEADLINE_ADDED_TO_COURSE,year,month,day,courseName);
			}
		}
	}

	private static void courseTests(EvaluationsCalendar evCalendar, Scanner in) {
		String courseName = in.nextLine().trim();
		Iterator<CourseTests> testsIT;
		
		if(!evCalendar.existsCourse(courseName))
			System.out.printf(ERROR_COURSE_NOT_EXIST, courseName);
		else {
			if(!evCalendar.hasTestsCourse(courseName))
				System.out.println(ERROR_NO_TEST_SCHEDULED);
			else {
				testsIT = evCalendar.listAllTestsInACourse(courseName);
				System.out.printf(HEADER_TESTS_COURSE, courseName);
				while(testsIT.hasNext()) {
					CourseTests test = testsIT.next();
					System.out.printf(LIST_TEST_COURSE, test.getDateHours(), test.getTestEnding(), test.getName());
				}		
			}	
		}	
	}

	private static void personalTests(EvaluationsCalendar evCalendar, Scanner in) {
		String personName = in.nextLine().trim();
        Iterator<CourseTests> testsIT;
        CourseTests test;

        if(!evCalendar.existPerson(personName))
            System.out.printf(ERROR_STUDENT_NOT_EXIST, personName);
        else {
            testsIT = evCalendar.getPersonalTests(personName);
            
            if(!testsIT.hasNext())
                System.out.printf(ERROR_NO_TEST_SCHEDULED, personName);
            else {
                System.out.printf(HEADER_TESTS_STUDENT, personName);
                while(testsIT.hasNext()) { 
                	test = testsIT.next();
                	  System.out.printf(LIST_TEST_STUDENT, test.getDateHours(), test.getTestEnding(), test.getTestCourse(), test.getName());	
                }     
            }
        }
	}

	private static void addTest(EvaluationsCalendar evCalendar, Scanner in) {
/*		String courseName,testName;
		int year,month,day,hour,minutes,duration;
		year=in.nextInt();
		month=in.nextInt();
		day=in.nextInt();
		hour=in.nextInt();
		minutes=in.nextInt();
		duration=in.nextInt();
		courseName=in.nextLine().trim();
		testName=in.nextLine().trim();
		if(!evCalendar.existsCourse(courseName))
			System.out.printf(ERROR_COURSE_NOT_EXIST,courseName);
		else{
			if(evCalendar.hasTestInCourse(courseName,testNameName))
				System.out.printf(ERROR_DEADLINE_EXISTS,deadlineName);
			else{
				evCalendar.addDeadlineCourse(courseName,deadlineName,year,month,day);
				System.out.printf(DEADLINE_ADDED_TO_COURSE,year,month,day,courseName);
			}
		}*/
	}

	private static void superProfessor(EvaluationsCalendar evCalendar) {
		Person superProfessor = evCalendar.superProfessor();
		int superProfessorStudents = evCalendar.getSuperProfessorStudents();
		
		if(superProfessor == null)
			System.out.println(ERROR_NO_PROFESSORS);
		else
			System.out.printf(LIST_SUPERPROFESSOR, superProfessor.getName(), superProfessorStudents);
	}

	private static void stressometer(EvaluationsCalendar evCalendar, Scanner in) {
		// TODO Auto-generated method stub	
	}


}
