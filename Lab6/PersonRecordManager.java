import java.util.Scanner;

public class PersonRecordManager extends RecordManager<Person> {

    public PersonRecordManager(MyLinkedList<Person> userRecords) {
        super(userRecords);
    }

    @Override
    public Person createRecord(Scanner sc) {
        System.out.print("Enter Employee Id: ");
        String id = sc.nextLine();

        System.out.print("Enter Person Name: ");
        String name = sc.nextLine();
        sc.nextLine();

        System.out.print("Enter Person Position: ");
        String position = sc.nextLine();

        System.out.print("Enter Person Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Person Age: ");
        int age = sc.nextInt();

        sc.nextLine();
        System.out.println("[-----------------]");

        return new Person(id, name, position, salary, age);
    }

    @Override
    public MyNode<Person> getNodeByAttribute(String attrValue) {
        MyNode<Person> currentNode = this.getRecordList().getHead();
        while (currentNode != null) {
            if (currentNode.getValue().getEmployeeId().equals(attrValue)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

}
