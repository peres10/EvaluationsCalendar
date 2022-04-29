package evaluationscalendar;

import java.time.*;

public class CourseTestsClass implements CourseTests{
    LocalDateTime dateHours;
    String name;
    String courseName;
    int duration;

    public CourseTestsClass(int year,int month,int day,int hour,int minutes,int duration,String name,String courseName){
        dateHours = LocalDateTime.of(year, month, day,hour,minutes);
        this.name = name;
        this.courseName = courseName;
        this.duration = duration;
    }

    public LocalDateTime getTestEnding(){
        return dateHours.plusHours(duration);
    }

    public String getName(){
        return name;
    }

    public LocalDateTime getDateHours(){
        return dateHours;
    }

    public String getTestCourse(){
        return courseName;
    }

    public int compareTo(CourseTests o) {
        if(this.dateHours.isBefore(o.getDateHours()))
            return -1;
        else if(this.dateHours.isAfter(o.getDateHours()))
            return 1;
        return 0;
    }
}