public class MainBy298 {

    public static void main(String[] args) {

        String names[] = { "Rashid", "Hamza", "Taqi", "Umer", "Arqum", "Ibad", "Shafin" };
        String rolls[] = { "298", "270", "283", "327", "254", "344", "252" };
        String programs[] = { "Software Engineer", "Software Engineer", "Software Engineer", "Software Engineer",
                "Software Engineer", "Software Engineer", "Software Engineer" };

        MyLinkedList<Person> p1 = PersonRecordDriver.generateLinkedList(names, rolls, programs);
        MyLinkedList<Person> p2 = new MyLinkedList<>();
        p2.add(new Person("289", "usama", "SE", 1000000, 50));

        p2.mergeLists(p1);

        System.out.println(p2.toString());

    }
}