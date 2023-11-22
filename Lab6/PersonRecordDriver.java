import java.util.Random;
import java.util.Scanner;

public class PersonRecordDriver {
    public static void pRecordManager(Scanner sc, String names[], String iDS[], String positions[]) {

        MyLinkedList<Person> fallStudentList = generateLinkedList(names, iDS, positions);
        PersonRecordManager pRM = new PersonRecordManager(fallStudentList);

        pRM.runRecordManager(sc);
        sc.close();
    }

    static MyLinkedList<Person> generateLinkedList(String[] names, String[] ids, String[] positions) {
        MyLinkedList<Person> personList = new MyLinkedList<>();

        Random random = new Random();

        for (int i = 0; i < names.length; i++) {
            String employeeId = ids[i];
            String name = names[i];
            String position = positions[i];
            double salary = random.nextDouble() * 10000;
            int age = random.nextInt(40) + 20;

            personList.add(new Person(employeeId, name, position, salary, age));
        }
        return personList;
    }

    public static void runManager(Scanner sc,String[] names, String[] ids, String[] positions){

        pRecordManager(sc,names,ids,positions);

    }
}
