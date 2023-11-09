public class StringConcat {
    //Rashid Ali -- 298
    public static void main(String[] args) {
        String str1 = "My Hobbies Include: ";
    String str2 = "Computer Games, ";
    String str3 = "Reading Novels, ";
    String str4 = "Catching up with modern Tech, ";
    String str5 = "and Staying at home!";

    String united = str1+str2+str3+str4+str5;

    System.out.println("Concatinated String:\n"+united);
    
    System.out.println("\nUppered String: "+str4.toUpperCase());
    System.out.println("\nSubString :"+united.substring(8));
    }
}
