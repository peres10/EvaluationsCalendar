package evaluationscalendar;
import dataStructures.*;

/**
 * A professors a person , but unlike the student it doesn't have a number
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public class ProfessorClass extends PersonClass implements Professor{
	public ProfessorClass(String name) {
		super(name);
	}

	/*
	 ****************************************** Getters ******************************************
	 */

	/*
		Gets the total number of students a professor has in all courses
	 */
	@Override
	public int getNumberOfStudents() {
		int numberOfStudents = 0;
		Iterator<Courses> coursesIT = getListOfCoursesInPerson();

		while(coursesIT.hasNext())
			numberOfStudents += coursesIT.next().getNumberOfStudents();

		return numberOfStudents;

	}
}
