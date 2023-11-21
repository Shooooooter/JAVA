import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SearchAlgorithms{
    public Object singleLinearSearch(int inputArray[], int key, boolean allOccurrences) {
        ArrayList<Integer> occurrencesResult = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == key) {
                occurrencesResult.add(i);
            }
        }
        if (allOccurrences) {
            return occurrencesResult.stream().mapToInt(Integer::intValue).toArray();
        } else if (!allOccurrences && occurrencesResult.size() > 0) {
            return occurrencesResult.get(0);
        } else {
            return -1;
        }
    }

    public HashMap<Integer, Integer> completeElementProfile(int inputArray[]) {
        HashMap<Integer, Integer> resultsDictionary = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            if (!resultsDictionary.containsKey(inputArray[i])) {
                int[] repetitions = (int[]) singleLinearSearch(inputArray, inputArray[i], true);
                resultsDictionary.put(inputArray[i], repetitions.length);
            }
        }

        return resultsDictionary;
    }

    public int[] conditionalMassLinearSearch(int[] inputArray, int conditionValue, boolean isGreater){
        Comparator<Integer> comparator = (isGreater) ? Integer::compare : (a, b) -> Integer.compare(b, a);
        List<Integer> resultIndices = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++){
            if (comparator.compare(inputArray[i], conditionValue)>0){
                resultIndices.add(inputArray[i]);
            }
            
        }
        return resultIndices.stream().mapToInt(Integer::intValue).toArray();
    }

    public int customBinarySearch(int[] inputArray, int key){
        return binarySearchReal(inputArray, key, 0, inputArray.length-1);
    }

    private static int binarySearchReal(int[] inputArray, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
    
        int mid = low + (high - low) / 2;
    
        if (inputArray[mid] == key) {
            return mid;
        } else if (inputArray[mid] < key) {
            return binarySearchReal(inputArray, key, mid + 1, high);
        } else {
            return binarySearchReal(inputArray, key, low, mid - 1);
        }
    }

    public void printArray(int[] inputArray){
        for (int i = 0; i < inputArray.length; i++){
            System.out.println("Index: "+i+"\tValue: "+(long) inputArray[i]);
        }
    }
    public void printDictionary(HashMap<Integer, Integer> inputArray) {
        for (Map.Entry<Integer, Integer> entry : inputArray.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + "\tValue: " + value);
        }
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
}