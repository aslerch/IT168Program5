import java.util.Scanner;

public class Main {

    private static Course [] coursesOffered = new Course [4];
    private static Student [] students = new Student [20];
    private static int numCoursesOffered = 0;
    private static int numStudents = 0;
    private static String stars = "*********************************************";
    private static String welcomeSign = stars
            + "\nWelcome to the university Registration System\n"
            + stars;
    private static String menu = """
            Please select one of the options below:
            1. Add course to the system
            2. Add student to the system
            3. Register a student to a course
            4. Display student information
            5. Exit the system""";
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String [] args) {

        // objects needed later
        int addCourse = 1, addStudent = 2, registerStudent = 3, displayStudent = 4, exit = 5;

        // main
        System.out.println(welcomeSign);
        int selection = -1;
        while ( selection != exit) {
            System.out.print(menu + "\nYour selection: ");
            selection = keyboard.nextInt();

            // user selects to add a course
            if (selection == addCourse) {
                if (numCoursesOffered == 4)
                    System.out.println("all course addition slots are taken. unable to add another course\n" + stars);
                if (numCoursesOffered != 4)
                    addCourse();
            }
        }
        System.out.println("Thank you for using the university Registration System");


    }

    private static void addCourse() {
        int courseId = askForCourseId();
        String courseName = askForCourseName();
        String departmentName = askForDepartmentName();
        Course newCourse = new Course(courseId, courseName, departmentName);
        coursesOffered[numCoursesOffered] = newCourse;
        numCoursesOffered++;
        System.out.println("Course was added successfully\n" + stars);
    }

    private static int askForCourseId() {
        int id;
            boolean flag;
            do {
                flag = false;
                System.out.print("please enter the course id: ");
                id = keyboard.nextInt();
                for (int i = 0; i < numCoursesOffered; i++) {
                    if (coursesOffered[i].getId() == id) {
                        System.out.println("the course id is already in use");
                        flag = true;
                    }
                }
            } while (flag);
        return id;
    }

    private static String askForCourseName() {
        System.out.print("please enter the course name: ");
        return keyboard.next();
    }

    private static String askForDepartmentName() {
        System.out.print("please enter the department name: ");
        return keyboard.next();
    }



}
