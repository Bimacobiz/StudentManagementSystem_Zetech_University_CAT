/**
 * Student.java
 * Demonstrates Encapsulation, Inheritance, Polymorphism, and Abstraction.
 */

/* ===== Abstraction (Abstract Class) ===== */
abstract class Person {
    protected String name;

    public Person(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public abstract void displayDetails();
}

/* ===== Abstraction (Interface) ===== */
interface GradingPolicy {
    String calculateGrade(int marks);
}

/* ===== Concrete grading policy ===== */
class StandardGradingPolicy implements GradingPolicy {
    @Override
    public String calculateGrade(int marks) {
        if (marks < 0 || marks > 100) return "Invalid";
        if (marks >= 70) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        return "Fail";
    }
}

/* ===== Student class ===== */
public class Student extends Person {

    private int studentId;
    private Course course;
    private int marks;

    private GradingPolicy gradingPolicy;

    public Student(int studentId, String name, Course course, int marks) {
        super(name);
        setStudentId(studentId);
        setCourse(course);
        setMarks(marks);
        this.gradingPolicy = new StandardGradingPolicy();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be positive.");
        }
        this.studentId = studentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        this.marks = marks;
    }

    public String getGrade() {
        return gradingPolicy.calculateGrade(marks);
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Student Details -----");
        System.out.println("ID     : " + studentId);
        System.out.println("Name   : " + name);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
        System.out.println("Grade  : " + getGrade());
        System.out.println("---------------------------");
    }
}
