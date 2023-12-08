package exception.parkinglot;

public class ParkingFullException extends RuntimeException  {
    public ParkingFullException(String message) {
        super(message);
    }
}
