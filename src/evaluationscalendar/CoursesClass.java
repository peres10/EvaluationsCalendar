package evaluationscalendar;

public class CoursesClass implements Courses {
	private String courseName;
	private int numberOfProfessors;
	private int numberOfStudents;
	private int numberOfTests;
	private int numberOfDeadlines;
	
	public CoursesClass(String courseName) {
		this.courseName = courseName;
		this.numberOfProfessors = 0;
		this.numberOfStudents = 0;
		this.numberOfTests = 0;
		this.numberOfDeadlines = 0;
	}
	
	public void addProfessor() {
		this.numberOfProfessors++;
	}
	
	public void addStudent() {
		this.numberOfStudents++;
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
	
	public int getNumberOfProfessors() {
		return this.numberOfProfessors;
	}
	@Override
	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}

	@Override
	public int getNumberOfTests() {
		return this.numberOfTests;
	}

	@Override
	public int getNumberOfDeadlines() {
		return this.numberOfDeadlines;
	}

}
