package evaluationscalendar;

import java.time.LocalDate;

/**
 * A deadline, that has a date , of name of the deadline (per example the name of the project that the deadline refers to)
 * and also saves the name of the course which the deadline belongs
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public interface Deadline extends Comparable<Deadline>{


    /*
     ****************************************** Getters ******************************************
     */

    /**
     * Returns the name of the deadline
     * @return String with the name of the deadline
     */
    String getName();


    /**
     * Returns the date of the deadline
     * @return LocalDate with the date of the deadline
     */
    LocalDate getDate();

    /**
     * Returns the name of the course which the deadline belongs
     * @return String with the name of the course
     */
    String getDeadlineCourse();


    /*
     ****************************************** Other methods ******************************************
     */

    /**
     * A compareTo implementation to sort deadlines by date
     * @param o - other deadline to compare
     * @return >0 if the date is after the parameter date, <0 if the date is before the parameter date, 0 if they are at the same time
     */
    int compareTo(Deadline o);

}
