package exception.parkinglot;

public class IllegalTicketException extends RuntimeException {
    public IllegalTicketException(String message) {
        super(message);
    }
}
