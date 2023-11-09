import java.util.Vector;
import java.util.Scanner;

// Rashid Ali
public class VectorSum {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Vector<Integer> vector = new Vector<Integer>();

      System.out.println("Enter 10 integers to add to the Vector:");

      for (int i = 0; i < 10; i++) {
         System.out.print("Enter integer " + (i + 1) + ": ");
         int num = scanner.nextInt();
         vector.add(num);
      }

      scanner.close();

      // Display all the integers in the Vector
      System.out.println("Integers in the Vector:");
      for (int num : vector) {
         System.out.print(num + " ");
      }

      // Calculate the sum of integers
      int sum = 0;
      for (int num : vector) {
         sum += num;
      }

      System.out.println("\nSum of the integers: " + sum);
   }
}
