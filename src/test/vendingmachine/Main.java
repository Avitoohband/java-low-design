package test.vendingmachine;


import exception.venidingmachine.InsufficientPaymentException;
import exception.venidingmachine.OutOfSupplyException;
import exception.venidingmachine.ProductNotSelectedException;
import venidngmachine.*;

import java.util.List;

public class Main {

    public static VendingMachine vendingMachine = new vendingMachineImpl();

    public static void main(String[] args) {

        vendingMachine.initiateVendingMachine();

//        testBuyNoChange();
//        testBuyWithChange();
//        testBuyWithProductNotSelectedException();
//        testBuyInsufficientPaymentException();
//        testBuyProductNotSelectedException();

    }

    public static void testBuyNoChange() {
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.selectProduct(Product.COKE);

        Bucket<Product, List<Coin>> dispensed = vendingMachine.dispenseItemAndChange();

        System.out.println(dispensed.item());
        System.out.println(dispensed.change());


    }

    public static void testBuyWithChange() {
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.DIME);

        vendingMachine.selectProduct(Product.COKE);

        Bucket<Product, List<Coin>> dispensed = vendingMachine.dispenseItemAndChange();

        System.out.println(dispensed.item());
        System.out.println(dispensed.change());

    }

    public static void testBuyWithProductNotSelectedException() {
        try {
            vendingMachine.dispenseItemAndChange();
        } catch (ProductNotSelectedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testBuyInsufficientPaymentException() {
        vendingMachine.selectProduct(Product.SODA);
        vendingMachine.insertCoin(Coin.QUARTER);

        try {
            vendingMachine.dispenseItemAndChange();
        } catch (InsufficientPaymentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testBuyProductNotSelectedException() {
        try {
            vendingMachine.selectProduct(Product.SODA);
        } catch (OutOfSupplyException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
