package evaluationscalendar;
import java.time.*;
import dataStructures.*;

/**
 * A Student, that is a Person but also has a student number
 * @author Tomas Ferreira nº61733
 * @author Alexandre Peres nº61615
 */
public class StudentClass extends PersonClass implements Student {
	private int studentNum;
	private int consecutiveDaysWithEvaluations = 0;
	private int numberOfEvaluationsDuringStress = 0;
	public StudentClass(String name,int studentNum) {
		super(name);
		this.studentNum = studentNum;
	}

    /*
     ****************************************** Setters ******************************************
     */
    /*
        Updates consecutiveDaysWithEvaluations and numberOfEvaluationsDuringStress variables
     */
    @Override
	public void studentStressometer() {
		Iterator<Courses> coursesIT = super.getListOfCoursesInPerson();
        Iterator<CourseTests> testsIT;
        Iterator<Deadline> deadlinesIT;
        Array<LocalDate> dates = new ArrayClass<>();
        Courses course;
        LocalDate day1;
        LocalDate day2;
        int consecutiveDays = 0, consecutiveDaysBackup = 0;
        int numberOfEvaluations = 0, numberOfEvaluationsBackup = 0;

        while(coursesIT.hasNext()) {
            course = coursesIT.next();
            
            testsIT = course.getListOfTestsCourse();
            deadlinesIT = course.getListOfDeadlinesCourse();
            
            while(testsIT.hasNext())
            	dates.insertLast(testsIT.next().getDate());
         
            while(deadlinesIT.hasNext())
            	dates.insertLast(deadlinesIT.next().getDate());
        }
        
        dates = dates.sort();
        
        if(dates.size() != 0) {
        	consecutiveDays = 1;
        	numberOfEvaluations = 1;
        }
        	
        for(int i = 0; i < dates.size()-1; i++) {
            day1 = dates.get(i);
            day2 = dates.get(i + 1);

            if(day1.equals(day2))
                numberOfEvaluations++;

            if(day1.plusDays(1).equals(day2)) {
                consecutiveDays++;
                numberOfEvaluations++;
            }
            else if(!day1.plusDays(1).equals(day2) && !day1.equals(day2)) {
                if(consecutiveDays > consecutiveDaysBackup) {
                    consecutiveDaysBackup = consecutiveDays;
                    numberOfEvaluationsBackup = numberOfEvaluations;
                    consecutiveDays = 1;
                    numberOfEvaluations = 1;
                }
            }
        }

        if(consecutiveDays > consecutiveDaysBackup) {
            consecutiveDaysBackup = consecutiveDays;
            numberOfEvaluationsBackup = numberOfEvaluations;
        }

        this.consecutiveDaysWithEvaluations = consecutiveDaysBackup;
        this.numberOfEvaluationsDuringStress = numberOfEvaluationsBackup;

    }


	/*
	 ****************************************** Getters ******************************************
	 */

	/*
		Gets the student number of a student
	 */
    @Override
	public int getStudentNumber() {
		return this.studentNum;
	}

    /*
        Gets consecutive days with tests
     */
    @Override
	public int getConsecutiveDaysWithTests() {
        return this.consecutiveDaysWithEvaluations;
    }

    /*
        Gets number of tests during stress
     */
    @Override
    public int getNumberOfTestsDuringStress() {
        return this.numberOfEvaluationsDuringStress;
    }


    /*
     ****************************************** Other methods ******************************************
     */

    /*
        A compareTo implementation to sort deadlines by consecutive days with evaluations
     */
	@Override
	public int compareTo(Student o) {
		if(this.consecutiveDaysWithEvaluations > o.getConsecutiveDaysWithTests())
			return -1;
		else if(this.consecutiveDaysWithEvaluations < o.getConsecutiveDaysWithTests())
			return 1;
		return 0;
	}
}
