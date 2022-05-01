package evaluationscalendar;
import java.time.*;
import dataStructures.*;

/**
 * A Student, that is a Person but also has a student number
 */
public class StudentClass extends PersonClass implements Student{
	private int studentNum;
	private int consecutiveDaysWithTests = 0;
	private int numberOfTestsDuringStress = 0;
	public StudentClass(String name,int studentNum) {
		super(name);
		this.studentNum = studentNum;
	}

	public void studentStressometer() {
        Iterator<Courses> coursesIT = super.getListOfCoursesInPerson();
        Iterator<CourseTests> testsIT;
        Array<CourseTests> tests = new ArrayClass<>();
        Array<CourseTests> sortedTests;
        Courses course;
        LocalDateTime day1;
        LocalDateTime day2;
        int consecutiveDays = 0, consecutiveDaysBackup = 0;
        int numberOfTests = 0, numberOfTestsBackup = 0;

        while(coursesIT.hasNext()) {
            course = coursesIT.next();

            testsIT = course.getListOfTestsCourse();

            while(testsIT.hasNext())
                tests.insertLast(testsIT.next());
        }
        sortedTests = tests.sort();

        for(int i = 0; i < sortedTests.size()-1; i++) {
            day1 = sortedTests.get(i).getDateHours();
            day2 = sortedTests.get(i+1).getDateHours();

            if(day1.equals(day2))
                numberOfTests++;

            if(day1.plusDays(1).equals(day2)) {
                consecutiveDays++;
                numberOfTests++;
            }
            else if(!day1.plusDays(1).equals(day2) && !day1.equals(day2)) {
                if(consecutiveDays > consecutiveDaysBackup) {
                    consecutiveDaysBackup = consecutiveDays;
                    numberOfTestsBackup = numberOfTests;
                    consecutiveDays = 0;
                    numberOfTests = 0;
                }
            }
        }

        if(consecutiveDays > consecutiveDaysBackup) {
            consecutiveDaysBackup = consecutiveDays;
            numberOfTestsBackup = numberOfTests;
        }

        this.consecutiveDaysWithTests = consecutiveDaysBackup;
        this.numberOfTestsDuringStress = numberOfTestsBackup;

    }
	/*
	 ****************************************** Getters ******************************************
	 */
	/*
		Gets the student number of a student
	 */
	public int getStudentNumber() {
		return this.studentNum;
	}

	public int getConsecutiveDaysWithTests() {
        return this.consecutiveDaysWithTests;
    }

    public int getNumberOfTestsDuringStress() {
        return this.numberOfTestsDuringStress;
    }
}
