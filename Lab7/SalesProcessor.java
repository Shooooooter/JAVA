import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class SalesProcessor {
    private LinkedList<Sale> sales;

    public SalesProcessor() {
        sales = new LinkedList<>();
    }

    public void process(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String productName = fields[0];
            String date = fields[1];
            int quantity = Integer.parseInt(fields[2]);
            addSale(productName, date, quantity);
        }
        reader.close();
    }

    public void addSale(String productName, String date, int quantity) {
        sales.add(new Sale(productName, date, quantity));
    }

    public void sort() {
        sales.sort((s1, s2) -> s1.getDate().compareTo(s2.getDate()));
    }

    public Sale search(String productName) {
        for (Sale sale : sales) {
            if (sale.getProductName().equals(productName)) {
                return sale;
            }
        }
        return null;
    }

    public void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write("Product Name,Date,Quantity\n");
        for (Sale sale : sales) {
            writer.write(sale.getProductName() + "," + sale.getDate() + "," + sale.getQuantity() + "\n");
        }
        writer.close();
    }

    public void printRecords(int start, int end) {
        if (start < 1 || end > sales.size() || start > end) {
            System.out.println("Invalid range.");
            return;
        }

        System.out.println("Product Name\tDate\tQuantity");
        for (int i = start - 1; i < end; i++) {
            Sale sale = sales.get(i);
            System.out.println(sale.getProductName() + "\t" + sale.getDate() + "\t" + sale.getQuantity());
        }
    }

    public void insertRecord() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter Product Name:");
        String productName = scanner.nextLine();
    
        System.out.print("Enter Date:");
        String date = scanner.nextLine();
    
        System.out.print("Enter Quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
    
        addSale(productName, date, quantity);
        System.out.println("Record inserted successfully.");
    
        scanner.close();
    }

}
