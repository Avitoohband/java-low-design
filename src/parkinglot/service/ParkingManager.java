package parkinglot.service;

import exception.parkinglot.ParkingFullException;
import exception.parkinglot.VehicleNotFoundException;
import parkinglot.model.Ticket;
import parkinglot.model.parkingslot.ParkingSlot;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.model.vehicle.VehicleType;
import parkinglot.strategy.CostStrategy;

import java.util.*;

public class ParkingManager implements ParkingHandler {
    private static volatile ParkingManager parkingManager;
    private final List<ParkingSlot> parkingSlots;
    private final Map<String, Integer> vehicleToSlotMap;


    private ParkingManager() {
        this.parkingSlots = new ArrayList<>();
        this.vehicleToSlotMap = new HashMap<>();
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

    public void addParkingSlot(VehicleType vehicleType) {
        parkingSlots.add(ParkingSlot.ofVehicleType(vehicleType));
    }


    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        ParkingSlot slot = getAvailableParkingSlot(vehicle).orElseThrow(
                () -> new ParkingFullException("No slots available")
        );


        slot.park(vehicle);
        vehicleToSlotMap.put(vehicle.getVehiclePlate().trim(), parkingSlots.indexOf(slot));
        return new Ticket(vehicle.getVehiclePlate(), slot.getParkingNumber());
    }

    private Optional<ParkingSlot> getAvailableParkingSlot(Vehicle vehicle) {
        for (ParkingSlot slot : parkingSlots) {
            if (ensuredParkingSlot(vehicle, slot)) {
                return Optional.of(slot);
            }
        }
        return Optional.empty();
    }


    private boolean ensuredParkingSlot(Vehicle vehicle, ParkingSlot slot) {
        return slot.getIsEmpty() && slot.getSuitableVehicleType().equals(vehicle.getVehicleType());
    }

    @Override
    public Ticket unPark(Ticket ticket, CostStrategy costStrategy) {
        Integer slotIndex = vehicleToSlotMap.get(ticket.getVehiclePlateNumber().trim());

        if (Objects.isNull(slotIndex)) {
            throw new VehicleNotFoundException("Vehicle is not in the parking lot");
        }
        ParkingSlot slot = parkingSlots.get(slotIndex);
        slot.vacate();
        ticket.checkOut();
        ticket.setPrice(costStrategy.calculateCost(ticket));
        parkingSlots.set(slotIndex, slot);

        return ticket;
    }
}


