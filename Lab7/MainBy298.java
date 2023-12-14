import java.io.IOException;
import java.util.Scanner;

public class MainBy298 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to R-298 Sales Management System!");

        CsvGenerator.main(args);
        SalesProcessor salesData = new SalesProcessor();

        try {
            salesData.process("sales.csv");
            salesData.sort();

            salesData.printRecords(5, 8);

            salesData.insertRecord();

            salesData.printRecords(5, 8);

            salesData.saveToFile("NewSales.csv");
            System.out.println("Data saved automatically.");

            scanner.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
