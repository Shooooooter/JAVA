import java.lang.Math;
import java.util.Scanner;

public class FindingTheDigits {
    public static void main(String[] args) {
        Scanner ubiquitous = new Scanner (System.in);
        System.out.print("Enter an integer: ");
        long intValue = ubiquitous.nextLong();
        ubiquitous.close();

        System.out.println("Number of Digits in the integer "+intValue+" are: "+hasDigitsIn(intValue,(byte) 0));
    }
// Rashid Ali 298
    public static int hasDigitsIn(long value , byte digits){
        if (value == 0){
            return digits;
        } 
        long result = Math.floorDiv(value, 10);
        digits++;
        return hasDigitsIn(result, digits);

    }
}