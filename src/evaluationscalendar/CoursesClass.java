package evaluationscalendar;

import dataStructures.*;

public class CoursesClass implements Courses {
	private String courseName;
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

	@Override
	public Iterator<Person> getListOfProfessorsCourse(){
		return professors.iterator();
	}

	@Override
	public Iterator<Person> getListOfStudentsCourse(){
		return students.iterator();
	}


}
