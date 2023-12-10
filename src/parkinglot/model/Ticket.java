package parkinglot.model;

import java.util.Date;

public class Ticket {
    private int parkingNumber;
    private final String vehiclePlateNumber;
    private final Date enterTime;
    private Date exitTime;
    private double price;


    public Ticket(String vehiclePlateNumber, int parkingNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.parkingNumber = parkingNumber;
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

    public void checkOut() {
        setExitTime(new Date());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "parkingNumber=" + parkingNumber +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                ", enterTime=" + enterTime +
                ", exitTime=" + exitTime +
                ", price=" + price +
                '}';
    }
}
