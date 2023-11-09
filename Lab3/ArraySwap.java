import java.util.Arrays;
import java.util.Scanner;
// Rashid Ali 298
public class ArraySwap {
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

        swapArrays(array1, array2);

        System.out.println("Arrays after swapping:");
        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
    }

    public static int[] createArrayWithSeries(int size, int seriesNumber) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (i + 1) * seriesNumber;
        }
        return array;
    }

    public static void swapArrays(int[] arr1, int[] arr2) {
        if (arr1.length == 4 && arr2.length == 4) {
            for (int i = 0; i < 4; i++) {
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
            }
        } else {
            System.out.println("Arrays must be of size 4 to swap.");
        }
    }
}
