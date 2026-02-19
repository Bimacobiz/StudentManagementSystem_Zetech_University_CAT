import java.util.Scanner;

/**
 * Main Application class.
 */
public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Student Management System (OOP) ===");

        try {
            System.out.print("Enter Student ID: ");
            int id = readInt(scanner);

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Course Code (e.g., CSC101): ");
            String courseCode = scanner.nextLine().trim();

            System.out.print("Enter Course Name (e.g., OOP Design): ");
            String courseName = scanner.nextLine().trim();

            System.out.print("Enter Marks (0-100): ");
            int marks = readInt(scanner);

            Course course = new Course(courseCode, courseName);
            Student student = new Student(id, name, course, marks);

            System.out.println();
            student.displayDetails();

        } catch (IllegalArgumentException ex) {
            System.out.println("Input error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}
