import java.util.Scanner;

public class SeriesSumWithUserInput {
    public static void main(String[] args) {
        Scanner ubiquitous = new Scanner(System.in);
        System.out.print("Enter the head value for the series: ");
        int seriesHead = ubiquitous.nextInt();
        ubiquitous.close();
        System.out.println("Sum from " + seriesHead + " to 0 is: " + seriesSum(seriesHead));
    }
// Rashid Ali 298
    public static int seriesSum(int sentinel) {
        if (sentinel == 0) {
            return 0;
        }
        return sentinel + seriesSum(sentinel - 1);
    }
}
