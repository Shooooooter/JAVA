public class Student {

    private int semester;
    private float currentCGPA;

    private String name, rollNumber, enrolledProgram;

    public Student(float currentCGPA, int semester, String name, String rollNumber, String enrolledProgram) {
        this.currentCGPA = currentCGPA;
        this.semester = semester;
        this.name = name;
        this.rollNumber = rollNumber;
        this.enrolledProgram = enrolledProgram;
    }

    public Student(String name, String rollNumber, int semester, String enrolledProgram) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.semester = semester;
        this.enrolledProgram = enrolledProgram;

        if (this.semester == 1) {
            this.currentCGPA = 0;
        }

    }

    public String getEnrolledProgram() {
        return enrolledProgram;
    }

    public void setEnrolledProgram(String enrolledProgram) {
        this.enrolledProgram = enrolledProgram;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCurrentCGPA() {
        return currentCGPA;
    }

    public void setCurrentCGPA(float currentCGPA) {
        this.currentCGPA = currentCGPA;
    }

    @Override
    public String toString() {
        return ("Name:\t" + this.name + "\nRoll Number:\t" + this.rollNumber + "\nProgram:\t" + this.enrolledProgram
                + "\nSemester:\t" + this.semester + "\nCurrent CGPA\t" + this.currentCGPA) + "\n\n";
    }
}
