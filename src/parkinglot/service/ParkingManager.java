package parkinglot.service;

import exception.parkinglot.ParkingFullException;
import parkinglot.model.Ticket;
import parkinglot.model.parkingspot.ParkingSpot;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.strategy.CostStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements Parking {
    private static volatile ParkingManager parkingManager;
    private List<ParkingSpot> parkingSpots;


    private ParkingManager() {
        this.parkingSpots = new ArrayList<>();
    }

    public static ParkingManager getParkingManager() {
        if (parkingManager == null) {
            synchronized (ParkingManager.class) {
                if (parkingManager == null) {
                    parkingManager = new ParkingManager();
                }
            }
        }
        return parkingManager;
    }


    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        return null;
    }

    @Override
    public Ticket unPark(Ticket ticket, CostStrategy costStrategy) {
        return null;
    }
}
