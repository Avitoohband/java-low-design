package venidngmachine;

import exception.venidingmachine.ProductNotSelectedException;
import exception.venidingmachine.InsufficientChangeException;
import exception.venidingmachine.InsufficientPaymentException;
import exception.venidingmachine.OutOfSupplyException;
import util.CollectionUtil;

import java.util.*;

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
        if (!itemInventory.hasItem(product)) {
            throw new OutOfSupplyException(String.format("Item: %s is out of supply!", product.getProductName()));
        }
        selectedProduct = product;
    }

    @Override
    public void insertCoin(Coin coin) {
        if (CollectionUtil.isEmpty(coinsInserted)) {
            coinsInserted = new ArrayList<>();
        }
        coinsInserted.add(coin);
        currentBalance += coin.getCoinValue();
        coinInventory.depositItem(coin);
    }


    @Override
    public Bucket<Product, List<Coin>> dispenseItemAndChange() {

        if (Objects.isNull(selectedProduct)) {
            throw new ProductNotSelectedException("Must select product first");
        }
        Bucket<Product, List<Coin>> bucket;
        int itemPrice = selectedProduct.getPrice();

        if (currentBalance > itemPrice) {
            try {
                int changeNeeded = currentBalance - itemPrice;
                List<Coin> change = dispenseChange(changeNeeded);
                bucket = new Bucket<>(selectedProduct, change);
            } catch (InsufficientChangeException ex) {
                resetCurrentBuy();
                throw ex;
            }
        } else if (currentBalance == itemPrice) {
            bucket = new Bucket<>(selectedProduct, Collections.emptyList());
        } else {
            int missingMoney = itemPrice - currentBalance;
            resetCurrentBuy();
            throw new InsufficientPaymentException(String.format("You are missing %d. Payment is not enought!", missingMoney));
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

    private void resetCurrentBuy() {
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
            } else if (changeNeeded >= Coin.DIME.getCoinValue()
                    && coinInventory.getQuantity(Coin.DIME) > 0) {
                change.add(Coin.DIME);
                changeNeeded -= Coin.DIME.getCoinValue();
            } else if (changeNeeded >= Coin.NICKEL.getCoinValue()
                    && coinInventory.getQuantity(Coin.NICKEL) > 0) {
                change.add(Coin.NICKEL);
                changeNeeded -= Coin.NICKEL.getCoinValue();
            } else if (changeNeeded >= Coin.PENNY.getCoinValue()
                    && coinInventory.getQuantity(Coin.PENNY) > 0) {
                change.add(Coin.PENNY);
                changeNeeded -= Coin.PENNY.getCoinValue();
            } else {
                throw new InsufficientChangeException("Not enough change in the machine!");
            }
        }
        return change;
    }
}

