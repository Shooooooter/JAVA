import java.util.Arrays;
//Rashid Ali 298
public class MainBay298 {
    public static void main(String[] args) {
        SearchAlgorithms newSearch = new SearchAlgorithms();
        int[] userArray = newSearch.generateRandomNumbers(50, 10, 40);
        System.out.println(Arrays.toString(userArray));
        newSearch.printDictionary(newSearch.completeElementProfile(userArray));
    }
}