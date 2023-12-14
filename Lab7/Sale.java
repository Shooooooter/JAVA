public class Sale {
    private String productName;
    private String date;
    private int quantity;

    public Sale(String productName, String date, int quantity) {
        this.productName = productName;
        this.date = date;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }
}
