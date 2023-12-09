package parkinglot.model;

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

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public void  checkOut() {
        setExitTime(new Date());
//        setPrice(
//                ((getExitTime().getTime() - getEnterTime().getTime())) * ((double) 20 / 3600)
//        );
//        return getPrice();
    }
}
