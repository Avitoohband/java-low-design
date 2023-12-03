package exception.venidingmachine;

public class InsufficientChangeException extends  RuntimeException{

    public InsufficientChangeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
