import java.util.Scanner;

// Rashid Ali 298
public class ArraySumAndMean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] realNumbers = new double[7];

        System.out.println("Enter 7 real numbers:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            realNumbers[i] = scanner.nextDouble();
        }

        System.out.print("Enter the key to split at: ");
        double splitKey = scanner.nextDouble();

        scanner.close();

        double sum = 0;
        for (double num : realNumbers) {
            sum += num;
        }
        double mean = sum / 7;

        System.out.println("Real Numbers:");
        for (double num : realNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nSum of real numbers: " + sum);
        System.out.println("Mean of real numbers: " + mean);

        External.showMemory();

        double[][] splitArrays = splitArray(realNumbers, splitKey);

        System.out.println("\nSplit Arrays:");
        for (double[] arr : splitArrays) {
            for (double num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static double[][] splitArray(double[] array, double key) {
        int keyIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                keyIndex = i;
                break;
            }
        }

        if (keyIndex == -1) {
            System.out.println("Key not found in the array; no split performed.");
            return new double[][] { array };
        }

        int firstArrayLength = keyIndex + 1;
        int secondArrayLength = array.length - keyIndex - 1;

        double[] firstArray = new double[firstArrayLength];
        double[] secondArray = new double[secondArrayLength];

        System.arraycopy(array, 0, firstArray, 0, firstArrayLength);
        System.arraycopy(array, keyIndex + 1, secondArray, 0, secondArrayLength);

        System.out.println("Array split at index " + keyIndex);

        return new double[][] { firstArray, secondArray };
    }
}
