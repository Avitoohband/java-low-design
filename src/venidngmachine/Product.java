package venidngmachine;

public enum Product {

    //Coke(25), Pepsi(35), Soda(45)

    COKE("Coke", 25), PEPSI("Pepsi", 35), SODA("Soda", 45);

    private final String productName;
    private final int price;


    Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
