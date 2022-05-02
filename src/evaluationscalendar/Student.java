package evaluationscalendar;

/**
 * A Student, that is a Person but also has a student number
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public interface Student extends Comparable<Student>{


	/*
	 ****************************************** Setters ******************************************
	 */

	/**
	 * Updates consecutiveDaysWithEvaluations and numberOfEvaluationsDuringStress variables
	 */
	void studentStressometer();
	
    /*
     ****************************************** Getters ******************************************
     */

	/**
	 * Gets the student number of a student
	 * @return int with the student number
	 */
    int getStudentNumber();

	/**
	 * Gets the consecutive days with tests
	 * @return int with the number of consecutive days with tests
	 */
	int getConsecutiveDaysWithTests();

	/**
	 * Gets the number of tests during stress
	 * @return int with the number of tests during stress
	 */
	int getNumberOfTestsDuringStress();

	/*
	 ****************************************** Other methods ******************************************
	 */

	/**
	 * A compareTo implementation to sort deadlines by consecutive days with evaluations
	 * @param o - other student
	 * @return <0 if has more consecutive days with evaluations, >0 if has less, 0 if they have the same
	 */
	int compareTo(Student o);
}
