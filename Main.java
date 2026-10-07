import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            try {
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Add Marks");
                System.out.println("7. View Result");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Roll Number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine();

                        Student student =
                                new Student(rollNumber, name, course);

                        manager.addStudent(student);
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter Roll Number to search: ");
                        int searchRoll = scanner.nextInt();

                        Student foundStudent =
                                manager.searchStudent(searchRoll);

                        if (foundStudent != null) {
                            System.out.println("\nStudent Found");
                            System.out.println(
                                    "Roll Number: "
                                    + foundStudent.getRollNumber());
                            System.out.println(
                                    "Name: " + foundStudent.getName());
                            System.out.println(
                                    "Course: " + foundStudent.getCourse());
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to update: ");
                        int updateRoll = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = scanner.nextLine();

                        if (manager.updateStudent(
                                updateRoll, newName, newCourse)) {

                            System.out.println(
                                    "Student updated successfully.");

                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Roll Number to delete: ");
                        int deleteRoll = scanner.nextInt();

                        if (manager.deleteStudent(deleteRoll)) {
                            System.out.println(
                                    "Student deleted successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter Roll Number: ");
                        int marksRoll = scanner.nextInt();

                        System.out.print("Enter Java Marks: ");
                        double javaMarks = scanner.nextDouble();

                        System.out.print("Enter DBMS Marks: ");
                        double dbmsMarks = scanner.nextDouble();

                        System.out.print("Enter DSA Marks: ");
                        double dsaMarks = scanner.nextDouble();

                        if (manager.addMarks(
                                marksRoll,
                                javaMarks,
                                dbmsMarks,
                                dsaMarks)) {

                            System.out.println(
                                    "Marks added successfully.");

                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 7:
                        System.out.print("Enter Roll Number: ");
                        int resultRoll = scanner.nextInt();

                        manager.displayResult(resultRoll);
                        break;

                    case 8:
                        System.out.println(
                                "Thank you for using Student Management System.");

                        scanner.close();
                        return;

                    default:
                        System.out.println(
                                "Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number.");

                scanner.nextLine();
            }
        }
    }
}
