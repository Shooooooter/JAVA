import java.util.Scanner;
// Rashid Ali 298
public class DescendingRecursion {
    public static void main(String[] args) {
        Scanner ubiquitous = new Scanner(System.in);

        System.out.print("Enter The Number To Start The Descent: ");
        int num1 = ubiquitous.nextInt();
        ubiquitous.close();

        integerDescent(num1);

    }

    public static void integerDescent(int number) {
        System.out.println(number);
        if (number == 0) {
            System.out.println("Recursion Complete");
        } else {
            integerDescent(number - 1);
        }
    }
}
