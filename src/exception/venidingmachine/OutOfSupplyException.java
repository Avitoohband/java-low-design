package exception.venidingmachine;

public class OutOfSupplyException extends RuntimeException {

    public OutOfSupplyException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
