import java.util.Scanner;
// Rashid Ali
public class InputHashcode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Calculate the hash code
        int hashCode = userInput.hashCode();

        System.out.println("Hash Code of \"" + userInput + "\" is: " + hashCode);

        scanner.close();
    }
}
