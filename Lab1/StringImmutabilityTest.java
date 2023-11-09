public class StringImmutabilityTest {
    //Rashid Ali -- 298
    public static void main(String[] args) {
        String originalString = "I am learning";
        String modifiedString = originalString.concat(" Java programming");

        System.out.println("Original Sentence: " + originalString);
        System.out.println("Modified Sentence: " + modifiedString);
        System.out.println("Are they the same object reference? " + (originalString == modifiedString));
        System.out.println("Are the sentences still the same? " + originalString.equals(modifiedString));
    }
}
