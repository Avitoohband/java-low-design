package exception.parkinglot;

public class UnsuitableParkingException extends RuntimeException {
    public UnsuitableParkingException(String message) {
        super(message);
    }
}
