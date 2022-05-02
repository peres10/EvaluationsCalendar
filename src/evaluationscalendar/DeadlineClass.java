package evaluationscalendar;

import java.time.*;

/**
 * A deadline, that has a date , of name of the deadline (per example the name of the project that the deadline refers to)
 * and also saves the name of the course which the deadline belongs
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public class DeadlineClass implements Deadline{

    LocalDate date;
    String name;
    String courseName;

    public DeadlineClass(LocalDate testDate,String name,String courseName){
        date = testDate;
        this.name = name;
        this.courseName = courseName;
    }

    /*
     ****************************************** Getters ******************************************
     */

    /*
        Returns the name of the deadline
     */
    @Override
    public String getName(){
        return name;
    }

    /*
        Returns the date of the deadline
     */
    @Override
    public LocalDate getDate() { return date; }

    /*
        Returns the name of the course which the deadline belongs
     */
    @Override
    public String getDeadlineCourse() { return courseName; }


    /*
     ****************************************** Other methods ******************************************
     */

    /*
        A compareTo implementation to sort deadlines by date
     */
	@Override
	public int compareTo(Deadline o) {
		if(this.date.isBefore(o.getDate()))
			return -1;
		else if(this.date.isAfter(o.getDate()))
			return 1;
		return 0;
	}
}

