package venidngmachine;

import exception.venidingmachine.NoSufficientChangeException;
import exception.venidingmachine.NotPaidEnoughException;
import exception.venidingmachine.OutOfSupplyException;
import util.CollectionUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class vendingMachineImpl implements VendingMachine {
    private final Inventory<Coin> coinInventory = new Inventory<>();
    private final Inventory<Product> itemInventory = new Inventory<>();

    private Product selectedProduct;
    private List<Coin> coinsInserted;
    private int currentBalance;

    @Override
    public void initiateVendingMachine() {
        for (Coin coin : Coin.values()) {
            coinInventory.put(coin, 5);
        }
        for (Product item : Product.values()) {
            itemInventory.put(item, 5);
        }
    }

    @Override
    public void selectProduct(Product product) {
        if (itemInventory.hasItem(product)) {
            selectedProduct = product;
        } else {
            throw new OutOfSupplyException(String.format("Item: %s is out of supply!", product.getProductName()));
        }
    }

    @Override
    public void insertMoney(Coin coin) {
        if (CollectionUtil.isEmpty(coinsInserted)) {
            coinsInserted = new ArrayList<>();
        }
        coinsInserted.add(coin);
        currentBalance += coin.getCoinValue();
        coinInventory.depositItem(coin);
    }


    @Override
    public Bucket<Product, List<Coin>> dispenseItemAndChange() {
        Bucket<Product, List<Coin>> bucket;
        int itemPrice = selectedProduct.getPrice();

        if (currentBalance > itemPrice) {
            try {
                int changeNeeded = currentBalance - itemPrice;
                List<Coin> change = dispenseChange(changeNeeded);
                bucket = new Bucket<>(selectedProduct, change);
            }catch (NoSufficientChangeException ex){
                System.out.println(ex.getMessage());
                resetCurrentBuy();
                return null;
            }
            int changeNeeded = currentBalance - itemPrice;
            List<Coin> change = dispenseChange(changeNeeded);
            bucket = new Bucket<>(selectedProduct, change);
        } else if (currentBalance == itemPrice) {
            bucket = new Bucket<>(selectedProduct, Collections.emptyList());
        } else {
            resetCurrentBuy();
            throw new NotPaidEnoughException(String.format("You are missing %d. Payment is not enough",
                    itemPrice - currentBalance));
        }
        itemInventory.withdrawItem(selectedProduct);
        resetCurrentBuy();
        return bucket;

    }

    @Override
    public List<Coin> refund() {
        List<Coin> refundedCoins = new ArrayList<>(coinsInserted);
        for (Coin coin : refundedCoins) {
            coinInventory.withdrawItem(coin);
        }
        resetCurrentBuy();

        return refundedCoins;
    }


    @Override
    public void reset() {
        coinInventory.resetInventory();
        itemInventory.resetInventory();
        resetCurrentBuy();
        initiateVendingMachine();
    }

    private void resetCurrentBuy(){
        selectedProduct = null;
        coinsInserted.clear();
        currentBalance = 0;
    }

    private List<Coin> dispenseChange(int changeNeeded) {
        List<Coin> changeCoins = calculateChangeCoins(changeNeeded);

        for (Coin coin : changeCoins) {
            coinInventory.withdrawItem(coin);
        }

        return changeCoins;
    }

    private List<Coin> calculateChangeCoins(int changeNeeded) {
        List<Coin> change = new ArrayList<>();

        while (changeNeeded > 0) {
            if (changeNeeded >= Coin.QUARTER.getCoinValue()
                    && coinInventory.getQuantity(Coin.QUARTER) > 0) {
                change.add(Coin.QUARTER);
                changeNeeded -= Coin.QUARTER.getCoinValue();
            } else if (changeNeeded >= Coin.NICKEL.getCoinValue()
                    && coinInventory.getQuantity(Coin.NICKEL) > 0) {
                change.add(Coin.NICKEL);
                changeNeeded -= Coin.NICKEL.getCoinValue();
            } else if (changeNeeded >= Coin.DIME.getCoinValue()
                    && coinInventory.getQuantity(Coin.DIME) > 0) {
                change.add(Coin.DIME);
                changeNeeded -= Coin.DIME.getCoinValue();
            } else if (changeNeeded >= Coin.PENNY.getCoinValue()
                    && coinInventory.getQuantity(Coin.PENNY) > 0) {
                change.add(Coin.PENNY);
                changeNeeded -= Coin.PENNY.getCoinValue();
            } else {
                throw new NoSufficientChangeException("Not enough change in the machine!");
            }

        }
        return change;
    }
}

