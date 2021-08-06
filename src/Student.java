import java.util.Arrays;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private double gpa;
    private Course [] courses = new Course[3];
    private int numEnrolledCourses = 0;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public Course[] getCourses() {
        return courses;
    }

    public int getNumEnrolledCourses() {
        return numEnrolledCourses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public void setNumEnrolledCourses(int numEnrolledCourses) {
        this.numEnrolledCourses = numEnrolledCourses;
    }

    public void enrollCourse(Course course) {
        courses[numEnrolledCourses] = course;
    }

    @Override
    public String toString() {
        String output =  "id: " + id +
                "\nname: " + firstName + " " + lastName +
                "\ncourses=\n";
        if ( numEnrolledCourses == 0 )
            output += "this student is not enrolled in any classes";
        if (numEnrolledCourses > 0) {
            for (int i  = 0; i < numEnrolledCourses; i++) {
                output += "course id: " + courses[i].getId() +
                        "\ndepartment: " + courses[i].getDepartmentName() +
                        "\ncourse name: " + courses[i].getCourseName();
                if (i != numEnrolledCourses)
                    output += "\n\n";
            }
            output += "*********************************************";
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Student))
            return false;
        Student studentObj = (Student) o;
        return studentObj.id == this.id & studentObj.firstName.equalsIgnoreCase(this.firstName) &
                studentObj.lastName.equalsIgnoreCase(this.lastName);
    }

}
