import java.util.ArrayList;
import java.util.Collections;
// Rashid Ali 298
public class EmployeeSorting {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "John",
                "Male",
                2010,
                60000,
                "HR"));
        employees.add(new Employee(2,
                "Alice", "Female",
                2015,
                55000,
                "Engineering"));
        employees.add(new Employee(3,
                "Bob",
                "Male", 2012,
                62000,
                "Marketing"));
        employees.add(new Employee(4,
                "Eve",
                "Female",
                2018,
                58000,
                "Finance"));

        System.out.println("Employees before sorting:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        Collections.sort(employees);
        System.out.println("\nEmployees after sorting by Year of Joining:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}