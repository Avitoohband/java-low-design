package parkinglot.service;

import exception.parkinglot.ParkingFullException;
import parkinglot.model.Ticket;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.strategy.CostStrategy;

public interface Parking {

    public Ticket park(Vehicle vehicle);
    public Ticket unPark(Ticket ticket, CostStrategy costStrategy);

}
