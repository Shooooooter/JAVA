import java.util.Arrays;
import java.util.Scanner;
 
public class ArrayMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of Array1: ");
        int size1 = scanner.nextInt();
        System.out.print("Enter the series number for Array1: ");
        int seriesNumber1 = scanner.nextInt();
        int[] array1 = createArrayWithSeries(size1, seriesNumber1);

        System.out.print("Enter the size of Array2: ");
        int size2 = scanner.nextInt();
        System.out.print("Enter the series number for Array2: ");
        int seriesNumber2 = scanner.nextInt();
        int[] array2 = createArrayWithSeries(size2, seriesNumber2);

        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
        scanner.close();

        int[] mergedArray = mergeArrays(array1, array2);
        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
    }

    public static int[] createArrayWithSeries(int size, int seriesNumber) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (i + 1) * seriesNumber;
        }
        return array;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int mergedSize = arr1.length + arr2.length;
        int[] mergedArray = new int[mergedSize];

        for (int i = 0; i < arr1.length; i++) {
            mergedArray[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            mergedArray[i + arr1.length] = arr2[i];
        }

        return mergedArray;
    }
}
