import java.util.Scanner;

public class StudentRecordManager extends RecordManager<Student> {

    public StudentRecordManager(MyLinkedList<Student> userRecords){
        super(userRecords);
    }

    @Override
    public Student createRecord(Scanner sc) {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Semester: ");
        int semester = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter Student Program: ");
        String program = sc.nextLine();

        System.out.print("Enter Student Roll Number: ");
        String rollNumber = sc.nextLine();

        System.out.print("Enter Student CGPA: ");
        float cGPA = sc.nextFloat();
        sc.nextLine();  
        System.out.println("[-----------------]");

        return new Student(cGPA, semester, name, program, rollNumber);
    }

    @Override
    public MyNode<Student> getNodeByAttribute(String attrValue) {
        MyNode<Student> currentNode = this.getRecordList().getHead();
        while (currentNode != null) {
            if (currentNode.getValue().getRollNumber().equals(attrValue)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
}
