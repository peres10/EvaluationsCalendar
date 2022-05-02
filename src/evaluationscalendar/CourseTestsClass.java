package evaluationscalendar;

import java.time.*;


/**
 * A test, that has a date and hours , of name of the test (per example 1st test), the duration of the test
 *  and also saves the name of the course which the deadline belongs
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public class CourseTestsClass implements CourseTests{
    LocalDateTime dateHours;
    String name;
    String courseName;
    int duration;

    public CourseTestsClass(LocalDateTime testDate,int duration,String name,String courseName){
        dateHours = testDate;
        this.name = name;
        this.courseName = courseName;
        this.duration = duration;
    }

    /*
        Returns the ending of the test
     */
    @Override
    public LocalDateTime getTestEnding(){
        return dateHours.plusHours(duration);
    }

    /*
        Returns the name of the test
     */
    @Override
    public String getName(){
        return name;
    }

    /*
        Returns the date and hours of the test
     */
    @Override
    public LocalDateTime getDateHours(){
        return dateHours;
    }

    /*
        Returns only the date of the test
     */
    @Override
    public LocalDate getDate() {

        return dateHours.toLocalDate();
    }

    /*
        Returns the course that test belongs in
     */
    @Override
    public String getTestCourse(){
        return courseName;
    }

    /*
        A compareTo implementation to sort CourseTests by date
     */
    @Override
    public int compareTo(CourseTests o) {
        if(this.dateHours.isBefore(o.getDateHours()))
            return -1;
        else if(this.dateHours.isAfter(o.getDateHours()))
            return 1;
        return 0;
    }
}
