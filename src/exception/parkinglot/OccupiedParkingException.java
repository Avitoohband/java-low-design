package exception.parkinglot;

public class OccupiedParkingException extends RuntimeException {
    public OccupiedParkingException(String message) {
        super(message);
    }
}
