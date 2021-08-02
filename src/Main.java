import java.util.Scanner;

public class Main {

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
        }
        System.out.println("Thank you for using the university Registration System");


    }



}
