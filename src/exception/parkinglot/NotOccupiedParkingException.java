package exception.parkinglot;

public class NotOccupiedParkingException extends RuntimeException {
    public NotOccupiedParkingException(String message) {
        super(message);
    }
}
