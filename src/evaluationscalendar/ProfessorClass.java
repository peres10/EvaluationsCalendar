package evaluationscalendar;
import dataStructures.*;
/**
 * A professors a person , but unlike the student it doesn't have a number
 */
public class ProfessorClass extends PersonClass{
	public ProfessorClass(String name) {
		super(name);
	}
	
	public int getNumberOfStudents() {
		int numberOfStudents = 0;
		Iterator<Courses> coursesIT = getListOfCoursesInPerson();
		
		while(coursesIT.hasNext())
			numberOfStudents += coursesIT.next().getNumberOfStudents();
		
		return numberOfStudents;
		
	}
}
