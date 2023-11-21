import java.util.ArrayList;
import java.util.Scanner;
 
public class StringArrayListMenu {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------------");
            System.out.println("Welcome to the 298 System");
            System.out.println("-------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Add a string");
            System.out.println("2. Display all elements");
            System.out.println("3. Display the largest string");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            System.out.println("-------------------------------\n");
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to add: ");
                    String inputString = scanner.nextLine();
                    stringList.add(inputString);
                    System.out.println("String added to the list.\n");
                    break;
                case 2:
                    System.out.println("All elements in the list:");
                    for (String str : stringList) {
                        System.out.println("- " + str);
                    }
                    System.out.println();
                    break;
                case 3:
                    if (stringList.isEmpty()) {
                        System.out.println("The list is empty.\n");
                    } else {
                        String largestString = findLargestString(stringList);
                        System.out.println("Largest string in the list: " + largestString + "\n");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the 298 System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.\n");
                    break;
            }
        }
    }

    public static String findLargestString(ArrayList<String> stringList) {
        String largest = stringList.get(0);
        for (String str : stringList) {
            if (str.length() > largest.length()) {
                largest = str;
            }
        }
        return largest;
    }
}