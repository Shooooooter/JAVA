import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CsvGenerator {
    private static final String[] PRODUCTS = {"Product A", "Product B", "Product C", "Product D", "Product E"};
    private static final String[] DATES = {"2023-11-01", "2023-11-05", "2023-11-09", "2023-11-13", "2023-11-17"};
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 1000;

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("sales.csv");
            writer.write("Product Name,Date,Quantity\n");
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                String productName = PRODUCTS[random.nextInt(PRODUCTS.length)];
                String date = DATES[random.nextInt(DATES.length)];
                int quantity = random.nextInt(MAX_QUANTITY - MIN_QUANTITY + 1) + MIN_QUANTITY;
                writer.write(productName + "," + date + "," + quantity + "\n");
            }
            writer.close();
            System.out.println("CSV file generated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
