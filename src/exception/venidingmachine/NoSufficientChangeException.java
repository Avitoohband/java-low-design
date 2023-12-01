package exception.venidingmachine;

public class NoSufficientChangeException extends  RuntimeException{

    public NoSufficientChangeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
