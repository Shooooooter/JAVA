import java.util.Scanner;

public class NameReversingRecursion {
    public static void main(String[] args) {
        Scanner ubiquitous = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String userName = ubiquitous.nextLine();
        ubiquitous.close();
        System.out.println("Reversed String: " + nameReversion(userName, ""));

    }
// Rashid Ali 298
    public static String nameReversion(String name, String reverseName) {
        if (name.length() == 0) {
            return reverseName;

        } else {
            reverseName = reverseName + name.charAt(name.length() - 1);
            name = name.substring(0, name.length() - 1);

            return nameReversion(name, reverseName);
        }
    }
}