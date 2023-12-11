package parkinglot.service;

import exception.parkinglot.ParkingFullException;
import exception.parkinglot.VehicleNotFoundException;
import parkinglot.model.Ticket;
import parkinglot.model.parkingspot.ParkingSpot;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.model.vehicle.VehicleType;
import parkinglot.strategy.CostStrategy;
import util.CollectionUtil;

import java.util.*;

public class ParkingManager implements ParkingHandler {
    private static volatile ParkingManager parkingManager;
    private final List<ParkingSpot> parkingSpots;
    private final Map<String, Integer> vehicleToSpotMap;


    private ParkingManager() {
        this.parkingSpots = new ArrayList<>();
        this.vehicleToSpotMap = new HashMap<>();
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

    public void addParkingSpot(VehicleType vehicleType) {
        parkingSpots.add(ParkingSpot.ofVehicleType(vehicleType));
    }


    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        if (!CollectionUtil.isEmpty(parkingSpots)) {
            for (ParkingSpot spot : parkingSpots) {
                if (spot.getIsEmpty() && spot.getSuitableVehicleType().equals(vehicle.getVehicleType())) {
                    spot.park(vehicle);
                    vehicleToSpotMap.put(vehicle.getVehiclePlate().trim(), parkingSpots.indexOf(spot))  ;
                    return new Ticket(vehicle.getVehiclePlate(), spot.getParkingNumber());
                }
            }
        }

        throw new ParkingFullException("No spots available");
    }

    @Override
    public Ticket unPark(Ticket ticket, CostStrategy costStrategy) {
        Integer spotIndex = vehicleToSpotMap.get(ticket.getVehiclePlateNumber().trim());

        if(Objects.isNull(spotIndex)){
            throw new VehicleNotFoundException("Vehicle is not in the parking lot");
        }
        ParkingSpot spot = parkingSpots.get(spotIndex);
        spot.vacate();
        ticket.checkOut();
        ticket.setPrice(costStrategy.calculateCost(ticket));
        parkingSpots.set(spotIndex, spot);

        return ticket;
    }
}


