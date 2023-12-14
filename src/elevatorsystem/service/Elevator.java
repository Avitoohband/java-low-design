package elevatorsystem.service;

import elevatorsystem.model.Direction;
import elevatorsystem.model.Request;
import elevatorsystem.model.Type;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Elevator {

    private int currentFloor;
    Direction direction;

    // jobs tracking,for up and down directions
    PriorityQueue<Request> upPendingQueue;
    PriorityQueue<Request> downPendingQueue;


    public Elevator(int currentFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;
        initiateQueues();
    }


    public static Elevator ofDefaults() {
        return new Elevator(
                0,
                Direction.IDLE
        );
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void run() {
        while (!upPendingQueue.isEmpty() || !downPendingQueue.isEmpty()) {
            processRequests();
        }
        System.out.println("All requests are finished!");
        setDirection(Direction.IDLE);
    }

    public void appendRequest(Request request) {
        Direction requestDirection = request.getDirection();
        PriorityQueue<Request> queue = isDirectionUp(requestDirection) ? upPendingQueue : downPendingQueue;
        String directionText = isDirectionUp(requestDirection) ? "up" : "down";
        if (request.getType().equals(Type.EXTERNAL)) {
            queue.offer(
                    new Request(
                            request.getSourceFloor(),
                            request.getSourceFloor(),
                            request.getType(),
                            request.getDirection()
                    )
            );

            System.out.format("Appending %s request, going to floor %d.\n", directionText, request.getSourceFloor());
        }

        queue.offer(request);

        System.out.format("Appending %s request, going to floor %d.\n", directionText, request.getDestinationFloor());


    }

    private void initiateQueues() {
        this.upPendingQueue = new PriorityQueue<>(
                Comparator.comparingInt(Request::getDestinationFloor));

        this.downPendingQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getDestinationFloor(),
                        a.getDestinationFloor())
        );
    }

    private void processRequests() {
        if (isDirectionUp(getDirection()) || getDirection().equals(Direction.IDLE)) {
            processUpRequests();
            processDownRequests();
        } else {
            processDownRequests();
            processUpRequests();

        }
    }

    private void processUpRequests() {
        while (!upPendingQueue.isEmpty()) {
            setCurrentFloor(
                    upPendingQueue.poll().getDestinationFloor()
            );
            System.out.println("Processing up requests. Elevator stopped at floor " + getCurrentFloor() + ".");
        }

        setDirection(
                !downPendingQueue.isEmpty() ? Direction.DOWN : Direction.IDLE
        );
    }

    private void processDownRequests() {
        while (!downPendingQueue.isEmpty()) {
            setCurrentFloor(
                    downPendingQueue.poll().getDestinationFloor()
            );
            System.out.println("Processing down requests. Elevator stopped at floor " + getCurrentFloor() + ".");
        }

        setDirection(
                !upPendingQueue.isEmpty() ? Direction.UP : Direction.IDLE
        );
    }


    private boolean isDirectionUp(Direction direction) {
        return direction.equals(Direction.UP);
    }
}
