package test.elevatorsystem;

import elevatorsystem.model.Direction;
import elevatorsystem.model.Request;
import elevatorsystem.service.Elevator;

public class Main {
    public static void main(String[] args) {

        Elevator elevator = Elevator.ofDefault();
        ExternalRequest externalRequest = new ExternalRequest(0, Direction.UP);
        InternalRequest internalRequest = new InternalRequest(5);

        Request request = new Request(externalRequest, internalRequest);


    }
}
