public class Course {

    private int id;
    private String courseName;
    private String departmentName;

    public Course(int id, String courseName, String departmentName) {
        this.id = id;
        this.courseName = courseName;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "id: " + id + ", course name: " + courseName + ", departmentName: " + departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if ( ! (o instanceof Course) )
            return false;
        Course courseObj = (Course) o;
        return courseObj.id == id & courseObj.courseName.equalsIgnoreCase(courseName) &
                courseObj.departmentName.equalsIgnoreCase(departmentName);
    }

}
