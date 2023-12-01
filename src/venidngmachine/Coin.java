package venidngmachine;

public enum Coin {

    //1,5,10,25 penny, nickel, dime, and quarter.

    PENNY(1), NICKEL(5), DIME( 10), QUARTER(25);

    private final int coinType;

    Coin(int coinValue) {
        this.coinType = coinValue;
    }

    public int getCoinValue() {
        return coinType;
    }
}
