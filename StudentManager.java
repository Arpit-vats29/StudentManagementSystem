import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {

        if (searchStudent(student.getRollNumber()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

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

    public Student searchStudent(int rollNumber) {

        for (Student student : students) {

            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }

        return null;
    }

    public boolean updateStudent(
            int rollNumber,
            String name,
            String course) {

        Student student = searchStudent(rollNumber);

        if (student != null) {

            student.setName(name);
            student.setCourse(course);

            return true;
        }

        return false;
    }

    public boolean deleteStudent(int rollNumber) {

        Student student = searchStudent(rollNumber);

        if (student != null) {

            students.remove(student);
            return true;
        }

        return false;
    }

    public boolean addMarks(
            int rollNumber,
            double javaMarks,
            double dbmsMarks,
            double dsaMarks) {

        Student student = searchStudent(rollNumber);

        if (student != null) {

            student.setJavaMarks(javaMarks);
            student.setDbmsMarks(dbmsMarks);
            student.setDsaMarks(dsaMarks);

            return true;
        }

        return false;
    }

    public void displayResult(int rollNumber) {

        Student student = searchStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n===== Student Result =====");
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Name: " + student.getName());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Java Marks: " + student.getJavaMarks());
        System.out.println("DBMS Marks: " + student.getDbmsMarks());
        System.out.println("DSA Marks: " + student.getDsaMarks());
        System.out.println("Total Marks: " + student.getTotalMarks());
        System.out.println("Percentage: "
                + student.getPercentage() + "%");
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Result: " + student.getResult());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void loadStudents(List<Student> loadedStudents) {
        students = loadedStudents;
    }
}
