package evaluationscalendar;

import dataStructures.*;

public class CoursesClass implements Courses {
	private final String courseName;
	private int numberOfTests;

	private Array<Person> professors;
	private Array<Person> students;
	private Array<Deadline> deadlines;

	public CoursesClass(String courseName) {
		this.courseName = courseName;
		professors = new ArrayClass<>();
		students = new ArrayClass<>();
		//tests = new ArrayClass<>();
		deadlines = new ArrayClass<>();
	}

	@Override
	public void addProfessor(Person professor) {
		professor.addCourse();
		professors.insertLast(professor);
	}

	@Override
	public void addStudent(Person student) {
		student.addCourse();
		students.insertLast(student);
	}

	@Override
	public void addTest() {
		this.numberOfTests++;
	}

	@Override
	public void addDeadline(int year,int month,int day,String name) {
		deadlines.insertLast(new DeadlineClass(year,month,day,name,this.courseName));
		Array<Deadline> deadlinesAux = deadlines.sort();
		deadlines = deadlinesAux;
	}
	
	@Override
	public String getName() {
		return this.courseName;
	}

	@Override
	public int getNumberOfProfessors() {
		return professors.size();
	}

	@Override
	public int getNumberOfStudents() {
		return students.size();
	}

	@Override
	public int getNumberOfTests() {
		return 0;//tests.size();
	}

	@Override
	public int getNumberOfDeadlines() {
		return deadlines.size();
	}

	@Override
	public Iterator<Person> getListOfProfessorsCourse() {
		return professors.iterator();
	}

	@Override
	public Iterator<Person> getListOfStudentsCourse() {
		return students.iterator();
	}

	public Array<Person> getArrayOfStudents() { 
		return students; 
	}

	public Array<Person> getArrayOfProfessors() { 
		return professors; 
	}

	public Iterator<Deadline> getListOfDeadlinesCourse() { return deadlines.iterator(); }

	private Deadline searchDeadline(String deadlineName) {
		Iterator<Deadline> deadlineIt = getListOfDeadlinesCourse();
		Deadline deadline;
		while(deadlineIt.hasNext()) {
			deadline = deadlineIt.next();
			if(deadline.getName().equals(deadlineName))
				return deadline;
		}
		return null;
	}

	 public boolean hasDeadline(String deadlineName){
		return searchDeadline(deadlineName) != null;
	}
}
