package evaluationscalendar;

public class StudentClass extends PersonClass implements Student{
	private int studentNum;
	public StudentClass(String name,int studentNum) {
		super(name);
		this.studentNum = studentNum;
	}

	public int getStudentNumber() {
		return this.studentNum;
	}

}
