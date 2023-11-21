import java.util.ArrayList;
import java.util.Collections;

public class EmployeeSorting {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Hamza",
                "Male",
                2010,
                60000,
                "HR"));
        employees.add(new Employee(2,
                "Taqi", "Male",
                2015,
                55000,
                "Engineering"));
        employees.add(new Employee(3,
                "Umer",
                "Male", 2012,
                62000,
                "Marketing"));
        employees.add(new Employee(4,
                "Shafin",
                "male",
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