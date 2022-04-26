package evaluationscalendar;

import java.time.*;

public class DeadlineClass implements Deadline{

    LocalDate date;
    String name;

    public DeadlineClass(int year,int month,int day,String name){
        date = LocalDate.of(year, month, day);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public LocalDate getDate() { return date; }
}

