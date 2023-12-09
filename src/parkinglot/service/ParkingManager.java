package parkinglot.service;

import exception.parkinglot.ParkingFullException;
import parkinglot.model.Ticket;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.strategy.CostStrategy;

public class ParkingManager implements Parking{
    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        return null;
    }

    @Override
    public Ticket unPark(Ticket ticket, CostStrategy costStrategy) {
        return null;
    }
}
