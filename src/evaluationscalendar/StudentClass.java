package evaluationscalendar;

/**
 * A Student, that is a Person but also has a student number
 */
public class StudentClass extends PersonClass implements Student{
	private int studentNum;

	public StudentClass(String name,int studentNum) {
		super(name);
		this.studentNum = studentNum;
	}

	/*
	 ****************************************** Getters ******************************************
	 */
	/*
		Gets the student number of a student
	 */
	public int getStudentNumber() {
		return this.studentNum;
	}

}
