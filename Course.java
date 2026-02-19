/**
 * Course class demonstrating Encapsulation.
 */
public class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        setCourseCode(courseCode);
        setCourseName(courseName);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty.");
        }
        this.courseCode = courseCode.trim().toUpperCase();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        this.courseName = courseName.trim();
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}
