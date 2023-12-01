package exception.venidingmachine;
public class NotPaidEnoughException extends RuntimeException {

    public NotPaidEnoughException(String message) {
        super(message);

    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
