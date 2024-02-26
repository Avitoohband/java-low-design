package elevatorsystem.model;

public class Request {
    private final int sourceFloor;
    private final int destinationFloor;
    private final Type type;
    private final Direction direction;

    public Request(int sourceFloor, int destinationFloor, Type type, Direction direction) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.type = type;
        this.direction = direction;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public Type getType() {
        return type;
    }

    public Direction getDirection() {
        return direction;
    }


}
