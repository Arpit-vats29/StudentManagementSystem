import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
    }

    // View All Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(
                "Roll Number: " + student.getRollNumber()
                + ", Name: " + student.getName()
                + ", Course: " + student.getCourse()
            );
        }
    }

    // Search Student
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }

        return null;
    }

    // Update Student
    public boolean updateStudent(int rollNumber, String name, String course) {
        Student student = searchStudent(rollNumber);

        if (student != null) {
            student.setName(name);
            student.setCourse(course);
            return true;
        }

        return false;
    }

    // Delete Student
    public boolean deleteStudent(int rollNumber) {
        Student student = searchStudent(rollNumber);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
}
