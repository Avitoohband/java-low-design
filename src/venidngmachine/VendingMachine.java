package venidngmachine;


import java.util.List;

public interface VendingMachine {

     void initiateVendingMachine();

     void selectProduct(Product product);

     void insertCoin(Coin money);

     Bucket<Product, List<Coin>> dispenseItemAndChange();

     List<Coin> refund();

     void reset();
}
