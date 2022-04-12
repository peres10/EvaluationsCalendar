package evaluationscalendar;

import dataStructures.*;

public class CoursesClass implements Courses {
	private String courseName;
	/*private int numberOfProfessors;
	private int numberOfStudents;*/
	private int numberOfTests;
	private int numberOfDeadlines;

	private Array<Person> professors;
	private Array<Person> students;

	public CoursesClass(String courseName) {
		this.courseName = courseName;
		professors = new ArrayClass<>();
		students = new ArrayClass<>();
		this.numberOfTests = 0;
		this.numberOfDeadlines = 0;
	}
	
	public void addProfessor(Person professor) {
		professors.insertLast(professor);
	}
	
	public void addStudent(Person student) {
		students.insertLast(student);
	}
	
	public void addTest() {
		this.numberOfTests++;
	}
	
	public void addDeadline() {
		this.numberOfDeadlines++;
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
		return this.numberOfTests;
	}

	@Override
	public int getNumberOfDeadlines() {
		return this.numberOfDeadlines;
	}

	public Iterator<Person> getListOfProfessorsCourse(){
		return professors.iterator();
	}

	public Iterator<Person> getListOfStudentsCourse(){
		return students.iterator();
	}


}
