package evaluationscalendar;

public class StudentClass extends PersonClass{
	private int studentNum;
	public StudentClass(String name,int studentNum) {
		super(name);
		this.studentNum = studentNum;
	}

	@Override
	public int getStudentNumber() {
		return this.studentNum;
	}

}
