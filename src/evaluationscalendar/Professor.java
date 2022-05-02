package evaluationscalendar;

/**
 * A professors a person , but unlike the student it doesn't have a number
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
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
