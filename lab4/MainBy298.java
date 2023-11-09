public class MainBy298 {
    public static void main(String[] args) {
        SortingAlgorithms newSort = new SortingAlgorithms();
        int[] userArray = newSort.generateRandomNumbers(6,1,50);
        System.out.println("");
        // Rashid Ali 298
        newSort.mergeSort(userArray, true, true);
    }

}