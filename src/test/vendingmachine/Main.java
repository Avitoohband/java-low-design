package test.vendingmachine;

import venidngmachine.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new vendingMachineImpl();
        vendingMachine.initiateVendingMachine();

        testBuy(vendingMachine);
    }

    public static void testBuy(VendingMachine vendingMachine){
        vendingMachine.insertMoney(Coin.QUARTER);
        vendingMachine.selectProduct(Product.COKE);

        Bucket<Product, List<Coin>> dispensed = vendingMachine.dispenseItemAndChange();

        System.out.println(dispensed.item());
        System.out.println(dispensed.change());

    }

}
