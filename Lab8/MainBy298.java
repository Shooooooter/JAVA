public class MainBy298 {
    // Rashid Ali 298
    public static void main(String[] args) {
        homeTask2();
        homeTask1();
        labTask3();
        labTask2();
        labTask1();
    }

    private static void labTask1() {
        MyDoublyLinkedList<EmployeeRecord> employeeList = new MyDoublyLinkedList<EmployeeRecord>(5);
        String[] names = { "Hamza", "Taqi", "Arqum", "Umer" };
        String[] designations = { "Manager", "Engineer", "Superviser", "Kaleid" };
        String[] departments = { "IT", "HR", "Finance", "Marketing", "Research" };
        String company = "Abyssal Tech";

        for (int i = 0; i < names.length; i++) {
            EmployeeRecord newEmployee = new EmployeeRecord(names[i],
                    designations[i % designations.length],
                    departments[i % departments.length], company);
            employeeList.add(newEmployee, 0);
        }

        System.out.println("Initial:\n" + employeeList);

        employeeList.addLast(new EmployeeRecord("Luffi", "Superviser",
                             "IT", company));

        employeeList.add(new EmployeeRecord("Hikaru", "Manager"
                            ,"IT", company), employeeList.getMid().getCount());

        employeeList.addFirst(new EmployeeRecord("Akiyame", "Kaleid"
                            ,"Finance", company));

        System.out.println("Final:_________________________\n" + employeeList);
    }

    private static void labTask2(){
        String[] names = { "Hamza", "Taqi", "Arqum", "Umer" };
        String[] departments = { "Computer Science", "Electrical Engineering",
                                "Mechanical Engineering", "Civil Engineering" };

        MyDoublyLinkedList<Student> studentList = new MyDoublyLinkedList<>(2);

        studentList.addFirst(new Student(names[0], departments[0], getRandomAge()));
        studentList.addLast(new Student(names[1], departments[1], getRandomAge()));

        System.out.println("Initial Student List:\n"+studentList);

        studentList.addFirst(new Student(names[2], departments[2], getRandomAge()));
        studentList.addLast(new Student(names[3], departments[3], getRandomAge()));

        System.out.println("\nFinal Student List:\n"+studentList);

    }

    private static int getRandomAge() {
        return (int) (Math.random() * 6) + 20;
    }

    private static void labTask3(){
            MyDoublyLinkedList<String> citiesList = new MyDoublyLinkedList<>(10);
    
            citiesList.addLast("Karachi");
            citiesList.addLast("Lahore");
            citiesList.addLast("Islamabad");
            citiesList.addLast("Quetta");
    
            System.out.println("Initial Doubly Linked List:");
            System.out.println(citiesList);
    
            citiesList.addFirst("Multan");
    
            System.out.println("\nDoubly Linked List after Adding Multan at First:");
            System.out.println(citiesList);
    
            citiesList.add("Peshawar", 2);
    
            System.out.println("\nDoubly Linked List after Adding Peshawar at Index 2:");
            System.out.println(citiesList);
    
            citiesList.del(1);
    
            System.out.println("\nDoubly Linked List after Deleting Lahore at Index 1:");
            System.out.println(citiesList);
    
            citiesList.del("Islamabad");
    
            System.out.println("\nDoubly Linked List after Deleting Islamabad by Value:");
            System.out.println(citiesList);
        
    }

    private static void homeTask1(){
        MyDoublyLinkedList<String> employeeList = new MyDoublyLinkedList<String>(5);
        String[] names = { "Hamza", "Taqi", "Arqum", "Umer" };

        for (int i = 0; i < 4; i++) {
            
            employeeList.addFirst(names[i]);
        }
        System.out.println("Unsorted:\n_________________________");
        System.out.println(employeeList);
        System.out.println("Sorted\n____________________________");
        employeeList.sort();
        System.out.println(employeeList);
    }

    private static void homeTask2(){
        MyDoublyLinkedList<String> myList = new MyDoublyLinkedList<>(10);

        // Add elements to the list
        myList.addLast("Earth");
        myList.addLast("Fire");
        myList.addLast("Air");
        myList.addLast("Water");

       
        System.out.println("Initial myList: " + myList);

        myList.addFirst("Metal");
        System.out.println("myList after adding element at first: " + myList);

        myList.addLast("Mud");
        System.out.println("myList after adding element at last: " + myList);

        System.out.println("First element in myList: " + myList.getHead());
        System.out.println("Last element in myList: " + myList.getTail());

        myList.removeFirst();
        System.out.println("myList after removing first element: " + myList);

        myList.removeLast();
        System.out.println("myList after removing last element: " + myList);
    
    }

}
