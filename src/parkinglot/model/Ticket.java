package parkinglot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private int parkingNumber;
    private final String vehiclePlateNumber;
    private final LocalDateTime enterTime;
    private LocalDateTime exitTime;
    private BigDecimal price;


    public Ticket(String vehiclePlateNumber, int parkingNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.parkingNumber = parkingNumber;
        this.enterTime = LocalDateTime.now();
    }

    public LocalDateTime getEnterTime() {
        return enterTime;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public void checkOut() {
        setExitTime(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "parkingNumber=" + parkingNumber +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                ", enterTime=" + getFormattedDate(enterTime) +
                ", exitTime=" + getFormattedDate(exitTime) +
                ", price=" + price +
                '}';
    }

    private String getFormattedDate(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd:HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
