public class DifferentStringInitializations {
    //Rashid Ali -- 298
    public static void main(String[] args) {
        // String Initialization Techniques

        String str1 = "Hello and welcome to Data Structures in JAVA!";
        String str2 = "We Like Programming in Python!";
        String str3 = new String("We Like Programming in Python!").intern();

        String str4 = "Strings are an Integral Part of Programming";
        String str5 = "String are very easy to manipulate!";
        String str6 = new String("We Like Programming in Python!");

        System.out.println("\nString 1 = " + str1);
        System.out.println("Comparing Equality String 2 and 3 = " + (str2 == str3));
        System.out.println("Comparing Equality String 3 and 6 = " + (str3 == str6));
        System.out.println("String 4 = " + str4);
        System.out.println("String 5 = " + str5);
    }
}
