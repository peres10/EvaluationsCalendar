package evaluationscalendar;

/**
 * A Student, that is a Person but also has a student number
 */
public interface Student {
    /**
     * Gets the student number of a student
     * @return int with the student number
     */

	void studentStressometer();
	
    /*
     ****************************************** Getters ******************************************
     */
    int getStudentNumber();

	int getConsecutiveDaysWithTests();

	int getNumberOfTestsDuringStress();
}
