package parkinglot.service;

import parkinglot.model.Ticket;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.strategy.CostStrategy;

public interface ParkingHandler {

    public Ticket park(Vehicle vehicle);
    public Ticket unPark(Ticket ticket, CostStrategy costStrategy);

}
