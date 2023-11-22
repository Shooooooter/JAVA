import java.util.Scanner;

public class StudentRecordDriver {

    public static void sRecordManager(Scanner sc, String names[], String rolls[], String programs[], int[] semesters,
            float[] cgpas) {

        MyLinkedList<Student> fallStudentList = generateLinkedList(names, rolls, programs, semesters, cgpas);
        StudentRecordManager sRM = new StudentRecordManager(fallStudentList);

        sRM.runRecordManager(sc);
        sc.close();
    }

    static MyLinkedList<Student> generateLinkedList(String[] names, String[] rollNumbers, String[] programs,
            int[] semesters, float[] cgpas) {
        MyLinkedList<Student> fallStudentList = new MyLinkedList<>();

        for (int i = 0; i < names.length; i++) {
            fallStudentList.add(new Student(cgpas[i], semesters[i], names[i], rollNumbers[i], programs[i]));
        }

        return fallStudentList;
    }

    public void runManager(Scanner sc, String names[], String rolls[], String programs[], int[] semesters,
            float[] cgpas){

        sRecordManager(sc, names, rolls, programs, semesters, cgpas);

    }

}