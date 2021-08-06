import java.util.Arrays;
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

            // user selects to add a student
            if (selection == addStudent) {
                if (numStudents == 20)
                    System.out.println("all students slots have been taken. unable to add another student\n" + stars);
                if (numStudents != 20)
                    addStudent();
            }

            // user selects to register a student
            if (selection == registerStudent)
                registerStudent();

            // user selects to display a student
            if (selection == displayStudent)
                displayStudent();

        }
        System.out.println("Thank you for using the university Registration System");
        System.out.println(Arrays.toString(students[0].getCourses()));


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
        keyboard.nextLine(); //input stream reasons
        return keyboard.nextLine();
    }

    private static String askForDepartmentName() {
        System.out.print("please enter the department name: ");
        return keyboard.nextLine();
    }

    private static void addStudent() {
        int id = askForStudentIdToAdd();
        String firstName = askForFirstName();
        String lastName = askForLastName();
        Student newStudent = new Student(id, firstName, lastName);
        students[numStudents] = newStudent;
        numStudents++;
        System.out.println("student was added successfully\n" + stars);
    }

    private static int askForStudentIdToAdd() {
        int id;
        boolean flag;
        do {
            flag = false;
            System.out.print("please enter the student's id: ");
            id = keyboard.nextInt();
            for (int i = 0; i < numStudents; i++) {
                if (students[i].getId() == id) {
                    System.out.println("this student id is already in use");
                    flag = true;
                }
            }
        } while (flag);
        return id;
    }

    private static String askForFirstName() {
        System.out.print("please enter the student's first name: ");
        keyboard.nextLine(); // input stream reasons
        return keyboard.nextLine();
    }

    private static String askForLastName() {
        System.out.print("please enter the student's last name: ");
        return keyboard.nextLine();
    }

    private static void registerStudent() {
        if (numCoursesOffered == 0)
            System.out.println("There are no courses in the system\n" + stars);
        if (numStudents == 0)
            System.out.println("There are no students in the system\n" + stars);
        if (numStudents > 0 & numCoursesOffered > 0) {
            int studentId = askForStudentIdToRegister();
            if (checkIfStudentExists(studentId) == false)
                System.out.println("The student does not exist");
            if (checkIfStudentExists(studentId) == true) {
                System.out.print("please enter the course id: ");
                int courseId = keyboard.nextInt();
                if (isAlreadyEnrolledInCourse(studentId, courseId))
                    System.out.println("student is already registered for this course\n" + stars);
                if (isAlreadyEnrolledInCourse(studentId, courseId) == false) {
                    enrollStudentInCourse(studentId, courseId);
                    System.out.println("student has been registered for the course successfully\n" + stars);
                }
            }
        }
    }

    private static boolean checkIfStudentExists(int id) {
        boolean studentExists = false;
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getId() == id)
                studentExists = true;
        }
        return studentExists;
    }

    private static boolean isAlreadyEnrolledInCourse(int studentId, int courseId) {
        boolean alreadyEnrolled = false;
        for (int i = 0; i < numCoursesOffered; i++) {
            for (int j = 0; j < students[findIndexOfStudent(studentId)].getNumEnrolledCourses(); j++) {
                if (coursesOffered[findIndexOfCourse(courseId)] == students[findIndexOfStudent(studentId)].getCourses()[j])
                    alreadyEnrolled = true;
            }
        }
        return alreadyEnrolled;
    }

    private static int findIndexOfStudent(int studentId) {
        int id = -1;
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getId() == studentId)
                id =  i;
        }
        return id;
    }

    private static int findIndexOfCourse(int courseId) {
        int id = -1;
        for (int i = 0; i <numCoursesOffered; i++) {
            if (coursesOffered[i].getId() == courseId)
                id = i;
        }
        return id;
    }

    private static void enrollStudentInCourse(int studentId, int courseId) {
        students[findIndexOfStudent(studentId)].getCourses()[students[findIndexOfStudent(studentId)].getNumEnrolledCourses()] = coursesOffered[findIndexOfCourse(courseId)];
        students[findIndexOfStudent(studentId)].setNumEnrolledCourses(students[findIndexOfStudent(studentId)].getNumEnrolledCourses() + 1);
    }

    private static int askForStudentIdToRegister() {
        int id;
        boolean flag;
        do {
            flag = false;
            System.out.print("please enter the student's id: ");
            id = keyboard.nextInt();
            for (int i = 0; i < numStudents; i++) {
                if (students[i].getId() == id) {
                    flag = true;
                }
                if (flag == false)
                System.out.println("there is no student with this id number");
            }
        } while (flag == false);
        return id;
    }

    private static void displayStudent() {
        int studentId = askForStudentIdToRegister();
        int index = findIndexOfStudent(studentId);
        System.out.println(students[index].toString());
    }



}
