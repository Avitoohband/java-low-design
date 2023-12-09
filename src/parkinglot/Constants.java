package parkinglot;

public class Constants {

    public static final boolean EMPTY = false;
    public static final int HOURLY_PRICE = 20;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final double WEEKEND_PERCENT = 1.5;
    public static final double TWO_WHEELER_PERCENT = 0.5;


    private Constants(){
        throw new AssertionError();
    }

}
