
import java.util.*;

public class Main {
    

    /**
     * Feedback dado pelo programa.
     */
    //headers and listing formats
    private static final String HEADER_HELP_COMMAND = "Available commands:";
    private static final String HEADER_PROFESSORS = "Professors:";
    private static final String HEADER_STUDENTS = "Students:";
    private static final String LIST_STUDENT_FORMAT = "[%d] %s (%d)\n";
    private static final String LIST_PROFESSOR_FORMAT = "%s (%d)\n";
    private static final String LIST_COURSES_FORMAT = "%s: %d professors, %d students, %d tests, %d deadlines.\n";
    private static final String LIST_STUDENT_W_NUMBER = "%d %s\n";
    // private static final String LIST_DEADLINE = ?
    // private static final String LIST_PERSONAL_DEADLINES = ?
    
    //error and success messages
    private static final String ERROR_UNKNOWN_COMMAND = "Unknown command %s. Type help to see available commands\n";
    private static final String ERROR_EMPTY_DATABASE = "No people registered!";
    private static final String ERROR_ALREADY_EXIST_PERSON = "%s already exists!\n";
    private static final String ERROR_NUMBER_TAKEN = "There is already a student with the number %d!\n";
    private static final String ERROR_NO_COURSES = "No courses registed!";
    private static final String ERROR_COURSE_EXISTS = "Course %s already exists!\n";
    private static final String ERROR_COURSE_NOT_EXIST = "Course %s does not exist!\n";
    private static final String ERROR_PROFESSOR_NOT_EXIST = "Professor %s does not exist!";
    private static final String ERROR_PROFESSOR_ALREADY_ASSIGNED = "Professor %s is already assigned to course %d!";
    private static final String ERROR_INADEQUATE_NUM_STUDENTS = "Inadequate number of students!";
    private static final String ERROR_STUDENT_ALREADY_ENROLLED = "Student %s is already enrolled in course %s!\n";
    private static final String ERROR_NO_PROFS_TO_LIST = "No professors or students to list!";
    private static final String ERROR_NO_DEADLINE_DEFINED = "No deadlines defined for %s";
    
    private static final String PERSON_OR_COURSE_ADDED = "%s added.\n";
    private static final String PROFESSOR_ASSIGNED = "Professor %s assigned to %s.\n";
    private static final String STUDENTS_ADDED_TO_COURSE = "%d students added to course %s.";

    
    private static final String EXIT_MSG = "Bye!";
    

    private enum Command{

    	ROSTER("adds a new course"),
    	ASSIGN("lists the professors and students of a course"),
    	ENROL("adds students to a course"),
    	INTERSECTION("lists all the people involved in all the given courses"),
    	COURSEDEADLINES("lists all deadlines in a given course"),
    	PERSONALDEADLINES("lists all the deadlines of a given person"),
    	DEADLINE("adds a new deadline"),
    	COURSETESTS("lists all tests in a given course"),
    	PERSONALTESTS("lists all tests for a given student"),
    	SCHEDULE("add a new test to a course"),
    	SUPERPROFESSOR("presents the professor with more students"),
    	STRESSOMETER("presents the students with the top N stressful sequences of evaluations"),
    	HELP("shows the available commands"),
    	EXIT("terminates the execution of the program"),
    	UNKNOWN("");
    	
    	private final String cmdDesc;
    	
    	private Command(String cmdDesc) {
    		this.cmdDesc=cmdDesc;
    	}
    	
    	private String description() {
    		return cmdDesc;
    	}
    };
    
    public static void main(String[] args) {
    	commands();
    }

    private static Command getCommand(String comm) {
    	try {
    		return Command.valueOf(comm);
    	} catch (IllegalArgumentException e) {
    		return Command.UNKNOWN;
    	}
    }
    	
    private static void commands(){
    	Scanner in = new Scanner(System.in);
    	String comm = in.next().toUpperCase();
    	Command c = getCommand(comm);
    	while(!c.equals(Command.EXIT)) {
    		switch(c) {
    			case HELP: helpCommands(); break;
    			case STRESSOMETER:break;
    			case UNKNOWN:
    				System.out.printf(ERROR_UNKNOWN_COMMAND,comm);
    				break;
    			default:
    				break;
    		}
    		comm = in.next().toUpperCase();
    		c = getCommand(comm);
    	}
    	System.out.println(EXIT_MSG);
    	in.close();
    }
    
    private static void helpCommands() {
    	for (Command command : Command.values()) {
    		if(command==Command.UNKNOWN)
    			return;
    		System.out.println(command.name().toLowerCase() + " - " + command.description());
    	}
    }
}
