package evaluationscalendar;

import java.time.*;

public class DeadlineClass implements Deadline{

    LocalDate date;
    String name;
    String courseName;

    public DeadlineClass(int year,int month,int day,String name,String courseName){
        date = LocalDate.of(year, month, day);
        this.name = name;
        this.courseName = courseName;
    }

    public String getName(){
        return name;
    }

    public LocalDate getDate() { return date; }

    @Override
    public String getDeadlineCourse() { return courseName; }
}

