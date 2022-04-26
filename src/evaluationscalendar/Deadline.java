package evaluationscalendar;

import java.time.LocalDate;

public interface Deadline extends Comparable<Deadline>{

    String getName();
    LocalDate getDate();
    String getDeadlineCourse();

}
