import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student> {
    private static final Set<Integer> usedRollNumbers = new HashSet<>();
    
    private String name;
    private int rollNumber;
    private String department;
    private int age;

    public Student(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.rollNumber = generateUniqueRollNumber();
    }

    private int generateUniqueRollNumber() {
        int newRollNumber;
        do {
            newRollNumber = (int) (Math.random() * 1000) + 1000; 
        } while (!usedRollNumbers.add(newRollNumber));
        return newRollNumber;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNumber, other.rollNumber);
    }

    @Override
    public String toString() {
        return "\nname: " + name + "\nrollNumber: " + rollNumber +
                "\ndepartment: " + department + "\nage=" + age + "\n--------------------";
    }
}
