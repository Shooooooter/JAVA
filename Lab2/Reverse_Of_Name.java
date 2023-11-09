public class Reverse_Of_Name {
    public static String reverseFullName(String name) {
        // Base case: if the name is empty or a single character, return the name
        if (name.length() <= 1) {
            return name;
        } else {
            // Recursive case: reverse the substring after the first character and
            // concatenate the first character at the end
            return reverseFullName(name.substring(1)) + name.charAt(0);
        }
    }

    public static void main(String[] args) {
        String fullName = "John Doe"; // Replace with your full name
        String reversedName = reverseFullName(fullName);
        System.out.println("Original Name: " + fullName);
        System.out.println("Reversed Name: " + reversedName);
    }
}