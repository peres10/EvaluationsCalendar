package evaluationscalendar;

public interface Courses {
	String getName();
	void addProfessor();
	
	void addStudent();
	
	void addTest();
	
	void addDeadline();
	
	int getNumberOfProfessors();
	
	int getNumberOfStudents();
	
	int getNumberOfTests();
	
	int getNumberOfDeadlines();
}
