import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    // Save students to file
    public static void saveStudents(List<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                    student.getRollNumber() + "," +
                    student.getName() + "," +
                    student.getCourse() + "," +
                    student.getJavaMarks() + "," +
                    student.getDbmsMarks() + "," +
                    student.getDsaMarks()
                );

                writer.newLine();
            }

            System.out.println("Student data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving student data.");
        }
    }

    // Load students from file
    public static List<Student> loadStudents() {

        List<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 6) {

                    int rollNumber = Integer.parseInt(data[0]);
                    String name = data[1];
                    String course = data[2];

                    double javaMarks =
                            Double.parseDouble(data[3]);

                    double dbmsMarks =
                            Double.parseDouble(data[4]);

                    double dsaMarks =
                            Double.parseDouble(data[5]);

                    Student student =
                            new Student(rollNumber, name, course);

                    student.setJavaMarks(javaMarks);
                    student.setDbmsMarks(dbmsMarks);
                    student.setDsaMarks(dsaMarks);

                    students.add(student);
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println("Error loading student data.");
        }

        return students;
    }
}
