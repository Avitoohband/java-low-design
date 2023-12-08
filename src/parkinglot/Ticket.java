package parkinglot;

import java.util.Date;

public class Ticket {
    private final Date enterTime;
    private int parkingNumber;
    private double price;
    private final String vehiclePlateNumber;
    private Date exitTime;


    public Ticket(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.enterTime = new Date();
    }

    public Date getEnterTime() {
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

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public void checkOut(){
        setExitTime(new Date());

    }

//    public double checkOut() {
//        setExitTime(System.currentTimeMillis());
//        setPrice(
//                (double) (getExitTime() - getEnterTime()) / 3600
//        );
//        return getPrice();
//    }
}
