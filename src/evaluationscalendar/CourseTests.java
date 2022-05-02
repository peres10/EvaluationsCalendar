package evaluationscalendar;

import java.time.*;

/**
 * A test, that has a date and hours , of name of the test (per example 1st test), the duration of the test
 *  and also saves the name of the course which the deadline belongs
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public interface CourseTests extends Comparable<CourseTests>{


    /*
     ****************************************** Getters ******************************************
     */

    /**
     * Returns the ending of the test
     * @return LocalDateTime with the test ending
     */
    LocalDateTime getTestEnding();

    /**
     * Returns the name of the test
     * @return String with the name
     */
    String getName();

    /**
     * Returns the date and hours of the test
     * @return LocalDateTime with the date and hours
     */
    LocalDateTime getDateHours();

    /**
     * Returns only the date of the test
     * @return LocalDate with the date of test
     */
    LocalDate getDate();

    /**
     * Returns the course that test belongs in
     * @return String with the name of the course
     */
    String getTestCourse();

    /*
     ****************************************** Other methods ******************************************
     */

    /**
     * A compareTo implementation to sort CourseTests by date
     * @param o - other test to compare
     * @return >0 if the date is after the parameter date, <0 if the date is before the parameter date, 0 if they are at the same time
     */
    int compareTo(CourseTests o);

}
