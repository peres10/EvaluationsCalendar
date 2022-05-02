package evaluationscalendar;

import java.time.*;

public interface CourseTests extends Comparable<CourseTests>{
    LocalDateTime getTestEnding();
    String getName();
    
    LocalDateTime getDateHours();
    
    LocalDate getDate();

    String getTestCourse();    
    
    public int getHours();
    
    public int getMinutes();
        
    int compareTo(CourseTests o);

}
