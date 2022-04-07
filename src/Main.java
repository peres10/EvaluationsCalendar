
import java.util.*;

public class Main {
    /**
     * Comandos do utilizador.
     */
    /*private static final String EXIT = "exit";
    private static final String HELP = "help";
    private static final String LIST_PEOPLE = "people";
    private static final String ADD_PROFESSOR = "professor";
    private static final String ADD_STUDENT = "student";
    private static final String LIST_COURSES = "courses";
    private static final String ADD_COURSE = "course";
    private static final String LIST_ROSTER = "roster";
    private static final String ASSIGN_PROF = "assign";
    private static final String ENROL_STUD = "enrol";
    private static final String INTERSECT = "intersection";
    private static final String LIST_COURSE_DEADLINES = "coursedeadlines";
    private static final String LIST_PERSONAL_DEADLINES = "personaldeadlines";
    private static final String ADD_DEADLINE = "deadline";
    private static final String LIST_COURSE_TESTS = "coursetests";
    private static final String LIST_PERSONAL_TESTS = "personaltests";
    private static final String SCHEDULE_TEST = "schedule";
    private static final String PROF_WITH_MORE_STUDS = "superprofessor";
    private static final String LIST_MOST_STRESSED_STUDENT = "stressometer";*/

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
    //help commands
    /*private static final String HELP_COMMAND_PEOPLE = "lists all people";
    private static final String HELP_COMMAND_PROFESSOR =  "adds a new professor";
    private static final String HELP_COMMAND_STUDENT = "adds a new student";
    private static final String HELP_COMMAND_COURSES = "lists all courses";
    private static final String HELP_COMMAND_COURSE = "adds a new course";
    private static final String HELP_COMMAND_ROSTER = "lists the professors and students of a course";
    private static final String HELP_COMMAND_ASSIGN = "adds a teacher to a course";
    private static final String HELP_COMMAND_ENROL = "adds students to a course";
    private static final String HELP_COMMAND_INTERSECTION = "lists all the people involved in all the given courses";
    private static final String HELP_COMMAND_COURSEDEADLINES = "lists all deadlines in a given course";
    private static final String HELP_COMMAND_PERSONALDEADLINES = "lists all the deadlines of a given person";
    private static final String HELP_COMMAND_DEADLINE = "adds a new deadline";
    private static final String HELP_COMMAND_COURSETESTS =  "lists all tests in a given course";
    private static final String HELP_COMMAND_PERSONALTESTS = "lists all tests for a given student";
    private static final String HELP_COMMAND_SCHEDULE = "add a new test to a course";
    private static final String HELP_COMMAND_SUPERPROFESSOR = "presents the professor with more students";
    private static final String HELP_COMMAND_STRESSOMETER = "presents the students with the top N stressful sequences of evaluations";
    private static final String HELP_COMMAND_HELP = "shows the available commands";
    private static final String HELP_COMMAND_EXIT = "terminates the execution of the program";*/
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

    private static final String PERSON_OR_COURSE_ADDED = "%s added.\n";
    private static final String PROFESSOR_ASSIGNED = "Professor %s assigned to %s.\n";
    private static final String EXIT_MSG = "Bye!";

    private enum Command{
    	PEOPLE("lists all people"),
    	PROFESSOR("adds a new professor"),
    	STUDENT("adds a new student"),
    	COURSES("lists all courses"),
    	COURSE("adds a new course"),
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
