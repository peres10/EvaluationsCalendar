package evaluationscalendar;

import java.time.*;

public interface CourseTests {
    LocalDateTime getTestEnding();
    String getName();
    LocalDateTime getDateHours();
    String getTestCourse();
    int compareTo(CourseTests o);

}
