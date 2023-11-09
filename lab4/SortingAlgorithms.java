import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Random;

public class SortingAlgorithms {

    public void selectionSort(int inputArray[], boolean isAscending, boolean logIterations) {
        // Rashid Ali 298
        System.out.println("Hello");
        int i, j, temp, sortControlIndex;
        int arrayLength = inputArray.length;

        for (i = 0; i < arrayLength; i++) {

            sortControlIndex = i;

            if (isAscending) {
                for (j = i + 1; j < arrayLength; j++) {
                    if (inputArray[j] < inputArray[sortControlIndex]) {
                        sortControlIndex = j;
                    }
                }
            } else {
                for (j = i + 1; j < arrayLength; j++) {
                    if (inputArray[j] > inputArray[sortControlIndex]) {
                        sortControlIndex = j;
                    }
                }
            }

            temp = inputArray[sortControlIndex];
            inputArray[sortControlIndex] = inputArray[i];
            inputArray[i] = temp;
            if (logIterations) {
                System.out.println(
                        "Swapping Value:\t" + inputArray[sortControlIndex] + "\tAt Index: " + sortControlIndex
                                + "\nWith Value:\t" + inputArray[i] + "\tAt Index: " + i + "\n");
            }
        }

    }

    public void bubbleSort(int inputArray[], boolean isAscending, boolean logIterations) {
        int temp, i, j, arrayLength, counter;
        arrayLength = inputArray.length;
        counter = 0;
        // Rashid Ali 298
        for (i = 0; i < arrayLength; i++) {
            if (isAscending) {
                for (j = 0; j < (arrayLength - 1); j++) {
                    if (inputArray[j] > inputArray[j + 1]) {
                        temp = inputArray[j];
                        inputArray[j] = inputArray[j + 1];
                        inputArray[j + 1] = temp;
                        counter++;
                        if (logIterations) {
                            System.out.println(counter + "|\t" + Arrays.toString(inputArray));
                        }
                    }
                }
            } else {
                for (j = 0; j < (arrayLength - 1); j++) {
                    if (inputArray[j] < inputArray[j + 1]) {
                        temp = inputArray[j];
                        inputArray[j] = inputArray[j + 1];
                        inputArray[j + 1] = temp;
                        counter++;
                        if (logIterations) {
                            System.out.println(counter + "|\t" + Arrays.toString(inputArray));
                        }
                    }
                }
            }
        }
    }

    public void mergeSort(int inputArray[], boolean isAscending, boolean logIterations) {
        if (inputArray.length > 1) {
            int mid = inputArray.length / 2;
            // Rashid Ali 298
            int rightArray[] = Arrays.copyOfRange(inputArray, mid, inputArray.length);
            int leftArray[] = Arrays.copyOfRange(inputArray, 0, mid);

            mergeSort(rightArray, isAscending, logIterations);
            mergeSort(leftArray, isAscending, logIterations);

            merge(inputArray, rightArray, leftArray, isAscending, logIterations);
        }
    }

    public void merge(int inputArray[], int leftArray[], int rightArray[], boolean isAscending, boolean logIterations) {
        int mergedArray[] = new int[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        // Rashid Ali 298
        Comparator<Integer> comparator = (isAscending) ? Integer::compare : (a, b) -> Integer.compare(b, a);

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {

            if (comparator.compare(leftArray[leftIndex], rightArray[rightIndex]) <= 0) {
                mergedArray[mergedIndex++] = leftArray[leftIndex++];
            } else {
                mergedArray[mergedIndex++] = rightArray[rightIndex++];
            }

            if (logIterations) {
                System.out.println("\nLeft Array: " + Arrays.toString(leftArray));
                System.out.println("Right Array: " + Arrays.toString(rightArray));
                System.out.println("Merge Array: " + Arrays.toString(mergedArray));
            }
        }

        while (leftIndex < leftArray.length) {
            mergedArray[mergedIndex++] = leftArray[leftIndex++];

            if (logIterations) {
                System.out.println("\nLeft Array: " + Arrays.toString(leftArray));
                System.out.println("Right Array: " + Arrays.toString(rightArray));
                System.out.println("Merge Array: " + Arrays.toString(mergedArray));
            }

        }

        while (rightIndex < rightArray.length) {
            mergedArray[mergedIndex++] = rightArray[rightIndex++];

            if (logIterations) {
                System.out.println("\nLeft Array: " + Arrays.toString(leftArray));
                System.out.println("Right Array: " + Arrays.toString(rightArray));
                System.out.println("Merge Array: " + Arrays.toString(mergedArray));
            }
        }

        System.arraycopy(mergedArray, 0, inputArray, 0, mergedArray.length);
    }

    public int[] userInputArray(int size) {
        Scanner ubiquitous = new Scanner(System.in);
        int array[] = new int[size];
        System.out.println("Enter Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ")--> : ");
            array[i] = ubiquitous.nextInt();
        }
        // Rashid Ali 298
        ubiquitous.close();
        return array;
    }

    public int[] generateRandomNumbers(int size, int lowerBound, int upperBound) {
        Random random = new Random();
        int[] randomNumbers = new int[size];
        // Rashid Ali 298
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            randomNumbers[i] = randomNumber;
        }

        return randomNumbers;
    }

    public int[] generateLinearSequenceArray(int size) {
        int[] sequence = new int[size];

        for (int i = 1; i < (size + 1); i++) {
            sequence[i - 1] = i;
        }

        return sequence;
    }

    public void printInitials(int array[], int size) {
        System.out.println("Array Length: "+array.length);
        System.out.println("First "+size+" elements are:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }

}