package parkinglot;

public class Ticket {
    private final long enterTime;
    private double price;
    private final String vehiclePlateNumber;
    private long exitTime;


    public Ticket(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.enterTime = System.currentTimeMillis();
    }

    public long getEnterTime() {
        return enterTime;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public double checkOut() {
        setExitTime(System.currentTimeMillis());
        setPrice(
                (double) (getExitTime() - getEnterTime()) / 3600
        );
        return getPrice();
    }
}
