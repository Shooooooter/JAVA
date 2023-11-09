public class DataAutoBoxing {
    //Rashid Ali -- 298
    public static void main(String[] args) {
        int num1 = 1520;
        double num2 = 3.987654321D;
        byte num3 = 55;
        
        System.out.println("Before Boxing:");
        System.out.println("num1 is " + num1);
        System.out.println("num2 : " + num2);
        System.out.println("num3 : " + num3);

        Integer num4 = num1;
        Double num5 = num2;
        Byte num6 = num3;
        
        System.out.println("\nAfter Boxing and Unboxing:");
        System.out.println("num4 : " + num4.intValue());
        System.out.println("num5 : " + num5.doubleValue());
        System.out.println("num6 : " + num6.byteValue());

        System.out.println("\nnum4 : " + num4.toString());
        System.out.println("num5 : " + num5.getClass());
        System.out.println("num6 : " + num6.hashCode());        
    }
}
