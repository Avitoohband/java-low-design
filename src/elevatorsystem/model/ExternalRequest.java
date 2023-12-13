package elevatorsystem.model;

public class ExternalRequest {
    private int sourceFloor;
    Direction direction;

    public ExternalRequest(int sourceFloor, Direction direction) {
        this.sourceFloor = sourceFloor;
        this.direction = direction;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
