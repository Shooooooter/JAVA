import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;
// Rashid Ali 298
public class IntegerVectorOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vector<Integer> integerVector = new Vector<>();

        System.out.println("Enter integer values (enter a non-integer value to finish):");
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            integerVector.add(value);
        }

        scanner.close();
        Collections.sort(integerVector);

        System.out.println("Sorted Vector: " + integerVector);

        int largest = integerVector.lastElement();
        System.out.println("Largest Number: " + largest);

        int smallest = integerVector.firstElement();
        System.out.println("Smallest Number: " + smallest);

        scanner.close();
    }
}
