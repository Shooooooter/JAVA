import java.util.Arrays;
import java.util.Scanner;

public class MemoizationTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Colors
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        // Inputs
        System.out.print("Enter the Degree Range: ");
        int degree = scanner.nextInt();
        System.out.print("Enter the Values per Degree: ");
        int dimension = scanner.nextInt();
        scanner.close();
        // Inputs Done

        // 2D Array
        int[][] resultArray1 = new int[degree - 1][];
        int[][] resultArray2 = new int[degree - 1][];

        // Start Time to calculate time ellapsed
        long startTime = System.currentTimeMillis();


        // Populating the Array
        for (int i = 2; i <= degree; i++) {
            NacciSequenceMemoization calc = new NacciSequenceMemoization();
            int[] tempArr = calc.calculateNacci(i,dimension);
            resultArray1[i - 2] = tempArr;
        }
        // End Time and Time Calculation
        long endTime = System.currentTimeMillis();
        long memoizationTime = endTime - startTime;

        for (int i = 0; i < degree - 1; i++) {
            System.out.println(RED + Arrays.toString(resultArray1[i]) + RESET);
        }

        startTime = System.currentTimeMillis();
        for (int i = 2; i <= degree; i++) {

            resultArray2[i - 2] = NacciSequenceMemoization.calculateNonMemoizedNacci(dimension, i);
        }
        endTime = System.currentTimeMillis();
        long nonMemoizedTime = endTime - startTime;

        for (int[] ar : resultArray2) {

            System.out.println(GREEN + Arrays.toString(ar) + RESET);
        }

        System.out.println("Time taken without memoization: " + nonMemoizedTime + "ms");
        System.out.println("Time taken with memoization: " + memoizationTime + "ms");
    }
}
