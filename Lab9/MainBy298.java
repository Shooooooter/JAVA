import java.util.Scanner;

// Rashid Ali
public class MainBy298 {
    public static void main(String[] args) {
        labTask1();
        labTask2();
        labTask3();
        labTask5();
        homeTaskOneAndThree();
        homeTask2();
    }

    private static void labTask1() {
        MyStack<String> coloredBalls = new MyStack<>(8);
        coloredBalls.push("Blanc"); // White
        coloredBalls.push("Rouge"); // Red
        coloredBalls.push("Violet");
        coloredBalls.push("Magenta");
        coloredBalls.push("Noir"); // Black
        coloredBalls.push("Cyan"); // Blue
        coloredBalls.push("Jaune"); // Yellow

        System.out.println("Ball Box: " + coloredBalls);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Ball to Extract: ");
        String selectedBall = sc.nextLine();
        sc.close();

        coloredBalls.pop(selectedBall);

        if (coloredBalls != null) {
            System.out.println("\nBall Box: " + coloredBalls + "\nRemoved Ball: " + selectedBall);
        }
    }

    private static void labTask2() {
        MyStack<String> Kaleidoscope = new MyStack<>(8);
        Kaleidoscope.push("HamzU");
        Kaleidoscope.push("Kitty");
        Kaleidoscope.push("Cat");
        System.out.println("After 3 Insertions: " + Kaleidoscope);
        Kaleidoscope.pop("HamzU");
        Kaleidoscope.push("AkumI");
        System.out.println("After a Deletion and an Insertion: " + Kaleidoscope);
    }

    private static void labTask3() {
        MyStack<String> stack = new MyStack<>(10);

        String[] namesToPush = { "Hamzu", "Akum", "Taqumi", "IbuZawe", "Umre Ra" };

        System.out.println("Pushing names onto the stack:");
        for (String name : namesToPush) {
            stack.push(name);
            System.out.println("Pushed: " + name);
        }

        System.out.println("\nPopping names from the stack:");
        for (int i = 1; i <= 5; i++) {
            try {
                String poppedName = stack.pop();
                System.out.println("Popped: " + poppedName);
            } catch (IllegalStateException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nCurrent state of the stack:");
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Is the stack full? " + stack.isFull());
    }

    private static void labTask5() {

        String result = InfixToPostfix.infixToPostfix("(A+B)*(C-D)");
        System.out.println("Postfix: "+result);
    }

    private static void homeTaskOneAndThree() {
        String result = InfixToPostfix.infixToPostfix("A+(B*C-(D/E|F)*G)*H");
        System.out.println(result);
        double result2 = InfixToPostfix.evaluatePostfix(result);
        System.out.println(result2);
    }

    private static void homeTask2() {

        StackQueue<String> novelQueue = new StackQueue<>();

        novelQueue.push("Pride and Prejudice");
        novelQueue.push("To Kill a Mockingbird");
        novelQueue.push("1984");
        novelQueue.push("The Great Gatsby");

        System.out.println("First novel:\t\t" + novelQueue.pop());
        System.out.println("Second novel:\t\t" + novelQueue.pop());

        novelQueue.push("The Catcher in the Rye");
        novelQueue.push("One Hundred Years of Solitude");

        System.out.println("Third novel:\t\t" + novelQueue.pop());
        System.out.println("Fourth novel:\t\t" + novelQueue.pop());
        System.out.println("Fifth novel:\t\t" + novelQueue.pop());
        System.out.println("Sixth novel:\t\t" + novelQueue.pop());

        System.out.println("\nAttempting to pop from an empty queue: " + novelQueue.pop());
    }
}
