public class Student {

    private int rollNumber;
    private String name;
    private String course;

    private double javaMarks;
    private double dbmsMarks;
    private double dsaMarks;

    public Student(int rollNumber, String name, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getJavaMarks() {
        return javaMarks;
    }

    public void setJavaMarks(double javaMarks) {
        this.javaMarks = javaMarks;
    }

    public double getDbmsMarks() {
        return dbmsMarks;
    }

    public void setDbmsMarks(double dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

    public double getDsaMarks() {
        return dsaMarks;
    }

    public void setDsaMarks(double dsaMarks) {
        this.dsaMarks = dsaMarks;
    }

    public double getTotalMarks() {
        return javaMarks + dbmsMarks + dsaMarks;
    }

    public double getPercentage() {
        return getTotalMarks() / 3;
    }

    public String getGrade() {

        double percentage = getPercentage();

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getResult() {

        if (javaMarks >= 40 &&
            dbmsMarks >= 40 &&
            dsaMarks >= 40) {

            return "PASS";
        }

        return "FAIL";
    }
}
