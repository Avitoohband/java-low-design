package exception.venidingmachine;
public class InsufficientPaymentException extends RuntimeException {


    public InsufficientPaymentException(String message) {
        super(message);

    }
}
