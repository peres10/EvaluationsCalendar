package evaluationscalendar;

/**
 * A professors a person , but unlike the student it doesn't have a number
 */
public interface Professor {

    /*
     ****************************************** Getters ******************************************
     */

    /**
     * Gets the total number of students a professor has in all courses
     * @return int with the total number of students
     */
    int getNumberOfStudents();
}
